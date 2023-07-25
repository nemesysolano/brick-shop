package com.brickshop.services.api

import com.brickshop.services.model.Product

interface ProductCatalog {
    fun allProducts() : Iterable<Product>
    fun productById(productId: Long) : Product
}