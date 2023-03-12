package br.com.gabriel.carddatabase

import br.com.gabriel.carddatabase.core.config.sqslistener.AmazonSqsProperties
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("br.com.gabriel.carddatabase")
@EnableConfigurationProperties(AmazonSqsProperties::class)
@EnableDynamoDBRepositories
class CardDatabaseApplication

fun main(args: Array<String>) {
    runApplication<CardDatabaseApplication>(*args)
}
