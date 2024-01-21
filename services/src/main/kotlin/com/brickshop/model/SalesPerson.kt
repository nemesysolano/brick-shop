package com.brickshop.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name="sales_person")
data class SalesPerson (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long?=null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "ship_address_street")
    val shipAddressStreet: String? = null,

    @Column(name = "ship_address_city")
    val shipAddressCity: String? = null,

    @Column(name = "ship_address_state")
    val shipAddressState: String? = null,

    @Column(name = "ship_address_country")
    val shipAddressCountry: String?= null,

    @Column(name = "ship_address_zip_code")
    val shipAddressZipCode: String ? = null,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "picture", columnDefinition = "TEXT")
    val picture: String? = null,
)