package com.brickshop.api.controller

import com.brickshop.ServicesApplication
import com.brickshop.model.Product
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [ServicesApplication::class])
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class ProductCatalogControllerTest {
    var logger = LoggerFactory.getLogger(ProductCatalogControllerTest::class.java)

    @Autowired
    lateinit var mvc: MockMvc

    val jasonMapper = jacksonObjectMapper()

    @Test
    @DisplayName("/product/all")
    fun testAllProducts() {
        val products:List<Product> = jasonMapper.readValue(
            mvc.get("/product/all")
                .andExpect { MockMvcResultMatchers.status().isOk() }
                .andReturn()
                .response
                .contentAsString,
        )


        assertFalse(products.isEmpty())
        logger.debug("${products.size} products retrieved!")
    }

    @Test
    @DisplayName("/product/{id}")
    fun productByIdSuccess() {
        val product: Product = jasonMapper.readValue(
            mvc.get("/product/1")
                .andExpect { MockMvcResultMatchers.status().isOk() }
                .andDo { MockMvcResultHandlers.print() }
                .andReturn()
                .response
                .contentAsString,
        )

        logger.debug(product.toString())
    }

}