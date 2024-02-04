package com.brickshop.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*
import java.math.BigDecimal
@Entity
@Table(name = "sales_person")
@Schema(description = "Represents a salesperson in the system")
data class SalesPerson(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the salesperson", example = "456")
    val id: Long? = null,

    @Column(name = "name")
    @Schema(description = "Name of the salesperson", example = "John Doe")
    val name: String? = null,

    @Column(name = "ship_address_street")
    @Schema(description = "Street address of the salesperson")
    val shipAddressStreet: String? = null,

    @Column(name = "ship_address_city")
    @Schema(description = "City of the salesperson's address")
    val shipAddressCity: String? = null,

    @Column(name = "ship_address_state")
    @Schema(description = "State or province of the salesperson's address")
    val shipAddressState: String? = null,

    @Column(name = "ship_address_country")
    @Schema(description = "Country of the salesperson's address")
    val shipAddressCountry: String? = null,

    @Column(name = "ship_address_zip_code")
    @Schema(description = "ZIP or postal code of the salesperson's address")
    val shipAddressZipCode: String? = null,

    @Column(name = "phone_number")
    @Schema(description = "Phone number of the salesperson")
    val phoneNumber: String? = null,

    @Column(name = "picture", columnDefinition = "TEXT")
    @Schema(description = "URL of the salesperson's picture")
    val picture: String? = null
)