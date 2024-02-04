package com.brickshop.api.controller

import com.brickshop.api.ProductCatalog
import com.brickshop.api.service.ProductCatalogService
import com.brickshop.model.Product
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("ProductCatalog")
@RequestMapping("/product")
@CrossOrigin(origins = ["*"])
@Tag(name = "Product Catalog", description = "REST API for managing products")
class ProductCatalogController(private val productCatalogService: ProductCatalogService) : ProductCatalog,
    BaseController() {

    @Operation(summary = "Retrieve all products")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "List of all products"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/all")
    override fun allProducts(): Iterable<Product> = productCatalogService.allProducts()

    @Operation(summary = "Retrieve a product by its ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Product details"),
            ApiResponse(responseCode = "404", description = "Product not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/{productId}")
    override fun productById(
        @Parameter(description = "Unique identifier of the product")
        @PathVariable("productId") productId: Long
    ): Product = httpResponse(
        productCatalogService.productById(productId),
        HttpStatus.NOT_FOUND,
        "No product with productId = $productId exists"
    ) { p -> p.id != null }


}