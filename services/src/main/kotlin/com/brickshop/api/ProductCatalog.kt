package com.brickshop.api

import com.brickshop.model.Product

interface ProductCatalog {
    fun allProducts() : Iterable<Product>
    fun productById(productId: Long) : Product
}