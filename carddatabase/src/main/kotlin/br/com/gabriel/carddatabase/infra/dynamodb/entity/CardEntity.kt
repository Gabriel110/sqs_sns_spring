package br.com.gabriel.carddatabase.infra.dynamodb.entity

import br.com.gabriel.carddatabase.infra.dynamodb.config.DynamoDBConfig
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted
import java.time.LocalDateTime

@DynamoDBTable(tableName = "card")
data class CardEntity(
    @field:DynamoDBHashKey(attributeName = "pk")
    var id: String? = null,
    @field:DynamoDBIndexHashKey(attributeName = "code", globalSecondaryIndexName = "codeIndex")
    var codigo: String? = null,
    @field:DynamoDBAttribute(attributeName = "descricao")
    var descricao: String? = null,
    @field:DynamoDBAttribute(attributeName = "created_at")
    @field:DynamoDBTypeConverted(converter = DynamoDBConfig.Companion.LocalDateTimeConverter::class)
    var createdAt: LocalDateTime? = null,
    @field:DynamoDBAttribute(attributeName = "updated_at")
    @field:DynamoDBTypeConverted(converter = DynamoDBConfig.Companion.LocalDateTimeConverter::class)
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
)
