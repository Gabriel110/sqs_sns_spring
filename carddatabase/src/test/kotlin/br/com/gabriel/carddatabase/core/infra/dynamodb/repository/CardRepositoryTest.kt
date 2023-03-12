package br.com.gabriel.carddatabase.core.infra.dynamodb.repository

import br.com.gabriel.carddatabase.core.domain.Card
import br.com.gabriel.carddatabase.infra.dynamodb.entity.converter.toDoman
import br.com.gabriel.carddatabase.infra.dynamodb.repository.CardRepository
import br.com.gabriel.carddatabase.integration.BaseIntegrationTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime

class CardRepositoryTest : BaseIntegrationTest() {

    @Autowired
    lateinit var cardRepository: CardRepository

    @Test
    fun `deve salvar e buscar regitro no banco de dados`() {
        val card = generateCard()
        cardRepository.persist(card)
        val fidCard = cardRepository.findByCode(card.codigo)
        assertEquals(card.codigo, fidCard?.toDoman()?.codigo)
        assertEquals(card.descricao, fidCard?.toDoman()?.descricao)
    }
    private fun generateCard() = Card(
        codigo = "3445677",
        descricao = "dragão_branco",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
    )
}
