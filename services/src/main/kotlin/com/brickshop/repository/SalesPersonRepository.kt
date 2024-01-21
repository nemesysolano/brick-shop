package com.brickshop.repository

import com.brickshop.model.SalesPerson
import org.springframework.data.repository.CrudRepository

interface SalesPersonRepository: CrudRepository<SalesPerson, Long> {
}