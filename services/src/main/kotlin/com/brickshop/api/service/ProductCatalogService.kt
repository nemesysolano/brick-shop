package com.brickshop.api.service

import com.brickshop.api.ProductCatalog
import com.brickshop.model.Product
import com.brickshop.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductCatalogService(private val productRepository: ProductRepository) : ProductCatalog {
    override fun allProducts(): Iterable<Product> = productRepository.findAll()
    override fun productById(productId: Long): Product = productRepository.findById(productId).orElse(Product())
}