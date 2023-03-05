package br.com.gabriel.carddatabase.core.config.sre.metrics

import io.micrometer.core.instrument.Metrics

class CunstomCoutMetric {

    fun countPersistDynamoCard(table: String) {
        val card = Metrics.counter("count_persited_data", "table", table)
        card.count()
    }
}
