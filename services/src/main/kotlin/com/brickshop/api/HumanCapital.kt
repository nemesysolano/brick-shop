package com.brickshop.api

import com.brickshop.model.SalesPerson
import com.brickshop.model.SalesPersonPerformanceReport

interface HumanCapital {
    fun allSalesPeople() : Iterable<SalesPerson>
    fun salesPersonById(salesPersonId: Long): SalesPerson
    fun last4QuartersPerformance(salesPersonId: Long): SalesPersonPerformanceReport
}