package com.example.server.mcp

import io.github.vishalmysore.mcp.server.MCPToolsController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.github.vishalmysore.a2a.domain.JsonRpcRequest
import io.github.vishalmysore.a2a.server.JsonRpcController
import io.github.vishalmysore.common.MCPActionCallback
import io.github.vishalmysore.mcp.domain.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/mcp")
class MCPController : MCPToolsController() {

    @GetMapping("/list-tools")
    override fun listTools(): ResponseEntity<Map<String, List<Tool>>> {
        val response = mapOf("tools" to super.getToolsResult().tools)
        return ResponseEntity.ok(response)
    }


    @PostMapping("/call-tool")
    fun callTool(@RequestBody request: ToolCallRequest): ResponseEntity<JSONRPCResponse> {
        var toolResult = super.callTool(request, MCPActionCallback())
        log.info("Received result: $toolResult")
        val response = JSONRPCResponse().apply {
            id = "133"
            result = toolResult
        }
        return ResponseEntity.ok(response)
    }

    @PostMapping("/cancel-notification")
    fun cancelNotification(@RequestBody request: CancelledNotification): ResponseEntity<CallToolResult?> {
        log.info("Received cancel notification for: $request")
        return ResponseEntity.ok(null)
    }

    companion object {
        private val log = LoggerFactory.getLogger(MCPController::class.java)
    }
}