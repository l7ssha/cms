package xyz.l7ssha.cms.configuration

import org.springframework.core.MethodParameter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import java.io.Serializable
import java.util.*

@ControllerAdvice
class OptionalResponseControllerAdvice : ResponseBodyAdvice<Any?> {
    class NotFoundException: Exception() {

    }

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return returnType.parameterType == Optional::class.java
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        if (returnType.parameterType == Optional::class.java && (body as Optional<*>).isEmpty) {
            throw NotFoundException()
        }

        return body
    }

    @ExceptionHandler(NotFoundException::class)
    fun handle(e: NotFoundException): ResponseEntity<Map<String?, Serializable?>?>? {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emptyMap())
    }
}
