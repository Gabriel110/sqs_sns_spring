package br.com.gabriel.carddatabase.core.config.sqslistener

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "amazon.sqs")
data class AmazonSqsProperties(
    private val endpoint: String = "http://localhost:4566",
    private val region: String = "sa-east-1",
    private val accessKey: String = "local",
    private val secretKey: String = "local",
    val maxNumberOfMessage: Int = 10,
) {
    fun credentialsProvider() = AWSStaticCredentialsProvider(BasicAWSCredentials(this.accessKey, this.secretKey))
    fun enpointConfiguration() = AwsClientBuilder.EndpointConfiguration(this.endpoint, this.region)
}
