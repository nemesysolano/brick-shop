package com.brickshop.services.model
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name="product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long?=null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "onhand")
    val onHand: Int? = null,

    @Column(name = "picture", columnDefinition = "TEXT")
    val picture: String? = null,

    @Column(name = "price")
    val price: BigDecimal? = null
)
