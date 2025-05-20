package com.example.server.mcp

import io.github.vishalmysore.mcp.server.MCPToolsController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.github.vishalmysore.a2a.domain.JsonRpcRequest

import io.github.vishalmysore.common.MCPActionCallback
import io.github.vishalmysore.mcp.domain.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity

/**
 * This is optional and can be used to implement a custom MCP controller.
 */
@RestController
@RequestMapping("/v1")
class MCPController : MCPToolsController() {

    @GetMapping("/tools")
    override fun listTools(): ResponseEntity<Map<String, List<Tool>>> {
        val response = mapOf("tools" to super.getToolsResult().tools)
        return ResponseEntity.ok(response)
    }


    @PostMapping("/tools/call")
    override fun callTool(@RequestBody request: ToolCallRequest): ResponseEntity<JSONRPCResponse> {
       return super.callTool(request, MCPActionCallback())

    }



    companion object {
        private val log = LoggerFactory.getLogger(MCPController::class.java)
    }
}