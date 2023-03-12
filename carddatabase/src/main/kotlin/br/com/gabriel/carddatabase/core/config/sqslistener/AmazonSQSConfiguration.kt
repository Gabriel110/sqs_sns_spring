package br.com.gabriel.carddatabase.core.config.sqslistener

import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import io.opentracing.contrib.aws.TracingRequestHandler
import io.opentracing.util.GlobalTracer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile

@Configuration
class AmazonSQSConfiguration(
    val amazonSqsProperties: AmazonSqsProperties
) {

    @Bean
    @Primary
    @Profile("!production")
    fun amazonSQSAsyncLocal() = defaultAmazonSQSAsyncClientBuilder()
        .withCredentials(amazonSqsProperties.credentialsProvider())
        .withEndpointConfiguration(amazonSqsProperties.enpointConfiguration())
        .build()

    @Bean
    @Primary
    @Profile("production")
    fun amazonSQSAsyncProduction() = defaultAmazonSQSAsyncClientBuilder().build()

    private fun defaultAmazonSQSAsyncClientBuilder(): AmazonSQSAsyncClientBuilder = AmazonSQSAsyncClientBuilder.standard()
        .withRequestHandlers(TracingRequestHandler(GlobalTracer.get()))
}
