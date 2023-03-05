package br.com.gabriel.carddatabase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CardDatabaseApplication

fun main(args: Array<String>) {
	runApplication<CardDatabaseApplication>(*args)
}
