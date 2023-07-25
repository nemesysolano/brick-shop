package com.brickshop.services.api.impl

import com.brickshop.services.api.ProductCatalog
import com.brickshop.services.model.Product
import com.brickshop.services.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductCatalogService(private val productRepository: ProductRepository) : ProductCatalog {
    override fun allProducts(): Iterable<Product> = productRepository.findAll()
    override fun productById(productId: Long): Product = productRepository.findById(productId).orElse(Product())
}