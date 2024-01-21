package com.brickshop.component

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class GoogleCloudStorage @Autowired constructor(
    @Value("classpath:gcp/last-4-quarters-performance.json") performanceReportResource: Resource
) {
    private lateinit var performanceReport:Map<String, List<BigDecimal>>
    init {
        val objectMapper = jsonMapper()
        performanceReport = objectMapper.readValue(String(performanceReportResource.contentAsByteArray))
    }
   fun last4QuartersPerformance(salesPersonName: String): List<BigDecimal>? {
        return performanceReport[salesPersonName]
   }
}