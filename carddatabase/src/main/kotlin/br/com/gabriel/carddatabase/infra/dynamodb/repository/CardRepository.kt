package br.com.gabriel.carddatabase.infra.dynamodb.repository

import br.com.gabriel.carddatabase.core.domain.Card
import br.com.gabriel.carddatabase.infra.dynamodb.entity.CardEntity
import br.com.gabriel.carddatabase.infra.dynamodb.entity.converter.toEntity
import br.com.gabriel.carddatabase.infra.gateway.CardGateway
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import org.apache.juli.logging.LogFactory
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository
class CardRepository(
    private val dynamoDBMapper: DynamoDBMapper,
) : CardGateway {

    var logg = LogFactory.getLog(CardRepository::class.java)
    override fun findByCode(code: String): CardEntity? {
        return runCatching {
            logg.info("Buscando car pelo codigo: $code")
            val expression: Map<String, AttributeValue> = mapOf(
                ":code" to AttributeValue().withS(code),
            )

            val queryExpression = DynamoDBQueryExpression<CardEntity>()
                .withIndexName("codeIndex")
                .withKeyConditionExpression("code = :code")
                .withConsistentRead(false)
                .withExpressionAttributeValues(expression)

            return dynamoDBMapper.query(CardEntity::class.java, queryExpression).firstOrNull()
        }.onFailure {
            throw RuntimeException("Error ao buscar card $it")
        }.getOrThrow()
    }
    override fun persist(card: Card) {
        runCatching {
            val entity = card.toEntity()
            dynamoDBMapper.save(entity).also {
                logg.info("card salvo!")
            }
        }.onFailure {
            throw RuntimeException("Error ao salver card $it")
        }
    }
}
