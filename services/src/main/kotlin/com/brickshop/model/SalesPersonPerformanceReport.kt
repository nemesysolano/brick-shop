package com.brickshop.model

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

@Schema(description = "Represents a salesperson's performance report, including personal details and sales figures")
data class SalesPersonPerformanceReport(
    @Schema(description = "Unique identifier of the salesperson", example = "456")
    val id: Long? = null,

    @Schema(description = "Name of the salesperson", example = "John Doe")
    val name: String? = null,

    @Schema(description = "Street address of the salesperson")
    val shipAddressStreet: String? = null,

    @Schema(description = "City of the salesperson's address")
    val shipAddressCity: String? = null,

    @Schema(description = "State or province of the salesperson's address")
    val shipAddressState: String? = null,

    @Schema(description = "Country of the salesperson's address")
    val shipAddressCountry: String? = null,

    @Schema(description = "ZIP or postal code of the salesperson's address")
    val shipAddressZipCode: String? = null,

    @Schema(description = "Phone number of the salesperson")
    val phoneNumber: String? = null,

    @Schema(description = "URL of the salesperson's picture")
    val picture: String? = null,

    @Schema(description = "Sales performance for the last 4 quarters, in order from most recent to least recent")
    val last4QuartersPerformance: List<BigDecimal>? = null
) {
    constructor(salesPerson: SalesPerson, last4QuartersPerformance: List<BigDecimal>): this(
        id = salesPerson.id,
        name = salesPerson.name,
        shipAddressStreet = salesPerson.shipAddressStreet,
        shipAddressCity = salesPerson.shipAddressCity,
        shipAddressState = salesPerson.shipAddressState,
        shipAddressCountry = salesPerson.shipAddressCountry,
        shipAddressZipCode = salesPerson.shipAddressZipCode,
        phoneNumber = salesPerson.phoneNumber,
        picture = salesPerson.picture,
        last4QuartersPerformance = last4QuartersPerformance
    )
}