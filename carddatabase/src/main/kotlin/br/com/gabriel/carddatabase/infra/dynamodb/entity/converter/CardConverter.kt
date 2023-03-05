package br.com.gabriel.carddatabase.infra.dynamodb.entity.converter

import br.com.gabriel.carddatabase.core.domain.Card
import br.com.gabriel.carddatabase.infra.dynamodb.entity.CardEntity
import java.util.UUID

fun Card.toEntity() = CardEntity(
    id = this.id ?: UUID.randomUUID().toString(),
    codigo = this.codigo,
    descricao = this.descricao,
    createdAt = this.updatedAt
)

fun CardEntity.toDoman() = Card(
    id = this.id,
    codigo = this.codigo!!,
    descricao = this.descricao!!,
    updatedAt = this.updatedAt!!,
    createdAt = this.updatedAt!!
)
