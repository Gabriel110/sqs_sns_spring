package br.com.gabriel.carddatabase.core.domain

import java.time.LocalDateTime

data class Card(
    var id: String? = null,
    var codigo: String,
    var descricao: String,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime? = null,
)
