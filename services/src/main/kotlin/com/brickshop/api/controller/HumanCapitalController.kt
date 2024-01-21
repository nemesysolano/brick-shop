package com.brickshop.api.controller

import com.brickshop.api.HumanCapital
import com.brickshop.api.service.HumanCapitalService
import com.brickshop.model.SalesPerson
import com.brickshop.model.SalesPersonPerformanceReport
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("HumanCapital")
@RequestMapping("/human-capital")
@CrossOrigin(origins = ["*"])
class HumanCapitalController (val humanCapitalService: HumanCapitalService): HumanCapital, BaseController() {
    @GetMapping("/all")
    override fun allSalesPeople(): Iterable<SalesPerson> = humanCapitalService.allSalesPeople()

    @GetMapping("/{salesPersonId}")
    override fun salesPersonById(@PathVariable("salesPersonId")  salesPersonId: Long): SalesPerson = httpResponse(
        humanCapitalService.salesPersonById(salesPersonId),
        HttpStatus.NOT_FOUND,
        "No sales person with salesPersonId = $salesPersonId exists"
    ) {salesPerson -> salesPerson.id != null}

    @GetMapping("/quarterly-report/{salesPersonId}")
    override fun last4QuartersPerformance(@PathVariable("salesPersonId")   salesPersonId: Long): SalesPersonPerformanceReport =  httpResponse(
        humanCapitalService.last4QuartersPerformance(salesPersonId),
        HttpStatus.NOT_FOUND,
        "No quarterly report for salesPersonId = $salesPersonId exists"
    ) {salesPerson -> salesPerson.id != null}
}