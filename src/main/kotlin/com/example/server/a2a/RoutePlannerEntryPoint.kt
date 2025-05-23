package com.example.server.a2a
import io.github.vishalmysore.a2a.domain.JsonRpcRequest
import io.github.vishalmysore.common.server.JsonRpcController

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/")
class RoutePlannerEntryPoint : JsonRpcController() {
    private val logger = LoggerFactory.getLogger(RoutePlannerEntryPoint::class.java)

    @PostMapping
    override fun handleRpc(@RequestBody request: JsonRpcRequest): Any {
        logger.info(request.toString())
        return super.handleRpc(request)
    }
}