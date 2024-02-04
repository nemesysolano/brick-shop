package com.brickshop.model
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
@Schema(description = "Represents a product in the catalog")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the product", example = "123")
    val id: Long? = null,

    @Column(name = "name")
    @Schema(description = "Name of the product", example = "Awesome Widget")
    val name: String? = null,

    @Column(name = "onhand")
    @Schema(description = "Quantity of the product available in stock", example = "5")
    val onHand: Int? = null,

    @Column(name = "picture", columnDefinition = "TEXT")
    @Schema(description = "URL of the product's image")
    val picture: String? = null,

    @Column(name = "price")
    @Schema(description = "Price of the product", example = "9.99")
    val price: BigDecimal? = null
)
