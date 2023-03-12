package br.com.gabriel.carddatabase.core.config.sqslistener

import com.amazonaws.services.sqs.AmazonSQSAsync
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
data class AmazonSQSListenerFactoryConfiguration(
    private val sqs: AmazonSQSAsync,
    private val amazonSqsProperties: AmazonSqsProperties,
) {

    @Bean
    fun simplesListenerMensageFactory(): SimpleMessageListenerContainerFactory {
        val factory = SimpleMessageListenerContainerFactory()
        factory.setAmazonSqs(sqs)
        factory.setMaxNumberOfMessages(amazonSqsProperties.maxNumberOfMessage)
        return factory
    }
}
