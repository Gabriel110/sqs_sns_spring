package br.com.gabriel.carddatabase.integration

import org.junit.jupiter.api.Tag
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@Tag("integration")
@SpringBootTest
@AutoConfigureMockMvc
abstract class BaseIntegrationTest
