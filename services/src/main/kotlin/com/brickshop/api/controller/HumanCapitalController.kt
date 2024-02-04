package com.brickshop.api.controller

import com.brickshop.api.HumanCapital
import com.brickshop.api.service.HumanCapitalService
import com.brickshop.model.SalesPerson
import com.brickshop.model.SalesPersonPerformanceReport
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("HumanCapital")
@RequestMapping("/human-capital")
@CrossOrigin(origins = ["*"])
@Tag(name = "Human Capital", description = "REST API for managing human capital data")
class HumanCapitalController(val humanCapitalService: HumanCapitalService) : HumanCapital, BaseController() {

    @Operation(summary = "Retrieve all salespeople")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "List of all salespeople"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/all")
    override fun allSalesPeople(): Iterable<SalesPerson> = humanCapitalService.allSalesPeople()

    @Operation(summary = "Retrieve a salesperson by their ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Salesperson details"),
            ApiResponse(responseCode = "404", description = "Salesperson not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/{salesPersonId}")
    override fun salesPersonById(
        @Parameter(description = "Unique identifier of the salesperson")
        @PathVariable("salesPersonId") salesPersonId: Long
    ): SalesPerson = httpResponse(
        humanCapitalService.salesPersonById(salesPersonId),
        HttpStatus.NOT_FOUND,
        "No salesperson with salesPersonId = $salesPersonId exists"
    ) { salesPerson -> salesPerson.id != null }

    @Operation(summary = "Retrieve the last 4 quarters' performance report for a salesperson")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Salesperson performance report"),
            ApiResponse(responseCode = "404", description = "Quarterly report not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/quarterly-report/{salesPersonId}")
    override fun last4QuartersPerformance(
        @Parameter(description = "Unique identifier of the salesperson")
        @PathVariable("salesPersonId") salesPersonId: Long
    ): SalesPersonPerformanceReport = httpResponse(
        humanCapitalService.last4QuartersPerformance(salesPersonId),
        HttpStatus.NOT_FOUND,
        "No quarterly report for salesPersonId = $salesPersonId exists"
    ) { salesPerson -> salesPerson.id != null }
}