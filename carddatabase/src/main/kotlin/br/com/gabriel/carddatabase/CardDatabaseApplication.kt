package br.com.gabriel.carddatabase

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableDynamoDBRepositories
class CardDatabaseApplication

fun main(args: Array<String>) {
    runApplication<CardDatabaseApplication>(*args)
}
