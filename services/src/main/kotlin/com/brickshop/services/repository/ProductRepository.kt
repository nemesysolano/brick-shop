package com.brickshop.services.repository

import com.brickshop.services.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
}