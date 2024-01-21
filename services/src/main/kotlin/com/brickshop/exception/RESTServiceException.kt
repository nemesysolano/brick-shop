package com.brickshop.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

class RESTServiceException(val errorStatus: HttpStatus, errorMessage: String) : RuntimeException(errorMessage) {
}