package com.brickshop.api.controller

import com.brickshop.ServicesApplication
import com.brickshop.model.Product
import com.brickshop.model.SalesPerson
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions
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
class HumanCapitalControllerTest {
    var logger = LoggerFactory.getLogger(HumanCapitalControllerTest::class.java)

    @Autowired
    lateinit var mvc: MockMvc
    val jasonMapper = jacksonObjectMapper()


    @Test
    @DisplayName("/human-capital/all")
    fun testAllSalesPeople() {
        val salesPeople:List<SalesPerson> = jasonMapper.readValue(
            mvc.get("/human-capital/all")
                .andExpect { MockMvcResultMatchers.status().isOk() }
                .andReturn()
                .response
                .contentAsString,
        )


        Assertions.assertFalse(salesPeople.isEmpty())
        logger.debug("${salesPeople.size} products retrieved!")
    }

    @Test
    @DisplayName("/human-capital/{id}")
    fun salesPersonByIdSuccess() {
        val salesPerson: SalesPerson = jasonMapper.readValue(
            mvc.get("/human-capital/1")
                .andExpect { MockMvcResultMatchers.status().isOk() }
                .andDo { MockMvcResultHandlers.print() }
                .andReturn()
                .response
                .contentAsString,
        )

        logger.debug(salesPerson.toString())
    }
}