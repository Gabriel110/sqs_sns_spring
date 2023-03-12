package br.com.gabriel.carddatabase.entrypint.sqs.consumer

import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.listener.Acknowledgment
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.messaging.MessageHeaders
import org.springframework.stereotype.Service

@Service
class CardConsumer {

    val logger = LoggerFactory.getLogger(CardConsumer::class.java)

    @SqsListener(
        value = ["\${queue.create-card-sqs}"],
        deletionPolicy = SqsMessageDeletionPolicy.NEVER,
    )
    fun consumer(payload: String, acknowledgment: Acknowledgment, headers: MessageHeaders) {
        logger.info(payload)
        acknowledgment.acknowledge().get()
    }
}
