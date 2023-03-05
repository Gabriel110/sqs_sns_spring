package br.com.gabriel.carddatabase.infra.gateway

import br.com.gabriel.carddatabase.core.domain.Card
import br.com.gabriel.carddatabase.infra.dynamodb.entity.CardEntity

interface CardGateway {

    fun findByCode(code: String): CardEntity?

    fun persist(card: Card)
}
