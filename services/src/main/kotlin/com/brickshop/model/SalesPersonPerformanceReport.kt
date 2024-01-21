package com.brickshop.model

import java.math.BigDecimal

data class SalesPersonPerformanceReport (
    val id: Long? = null,
    val name: String? = null,
    val shipAddressStreet: String? = null,
    val shipAddressCity: String? = null,
    val shipAddressState: String? = null,
    val shipAddressCountry: String? = null,
    val shipAddressZipCode: String? = null,
    val phoneNumber: String? = null,
    val picture: String? = null,
    val last4QuartersPerformance: List<BigDecimal>?  = null
) {
    constructor(salesPerson: SalesPerson, last4QuartersPerformance: List<BigDecimal>):  this(
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