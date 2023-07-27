package com.brickshop.services.controller

import com.brickshop.services.api.ProductCatalog
import com.brickshop.services.api.impl.ProductCatalogService
import com.brickshop.services.model.Product
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("ProductCatalog")
@RequestMapping("/product")
@CrossOrigin(origins = ["*"])
class ProductCatalogController(private val productCatalogService: ProductCatalogService) : ProductCatalog,
    BaseController() {

    @GetMapping("/all")
    override fun allProducts(): Iterable<Product> = productCatalogService.allProducts()

    @GetMapping("/{productId}")
    override fun productById(@PathVariable("productId")  productId: Long): Product = httpResponse(
        productCatalogService.productById(productId),
        HttpStatus.NOT_FOUND,
        "No product with productId = $productId exits"
    ) {p -> p.id != null}
}