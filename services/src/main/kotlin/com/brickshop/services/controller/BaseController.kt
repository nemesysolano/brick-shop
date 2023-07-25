package com.brickshop.services.controller

import com.brickshop.services.exception.RESTServiceException
import org.springframework.http.HttpStatus

open class BaseController {
    fun <T> httpResponse(item: T, errorStatus: HttpStatus,  errorMessage: String, okCondition: (item: T) -> Boolean): T {
        if(!okCondition(item)) {
            throw RESTServiceException(errorStatus, errorMessage)
        }
        return item
    }
}