package com.chpaar.api;

import com.chpaar.model.dto.OrderDto;
import com.chpaar.model.dto.OrderRequest;
import com.chpaar.model.dto.OrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Order Api")
@Tag(name = "Order")
@RequestMapping("/v1")
public interface OrderAPI {

    @Operation(summary = "Get all Order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!", content =
                    {@Content(mediaType = "application/json"
                            , array = @ArraySchema(schema = @Schema(implementation = OrderDto.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)})
    @GetMapping("/orders")
    ResponseEntity<List<OrderDto>> getAllOrders();

    //******************************************************************************************************************
    @Operation(summary = "Add a New Order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = OrderDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input")
            , @ApiResponse(responseCode = "409", description = "This Order already exists")})
    @PostMapping("/order")
    ResponseEntity<OrderDto> createOrder(@ApiParam(required = true) @Validated @RequestBody
                                                      OrderRequest orderRequest);

    //******************************************************************************************************************
    @Operation(summary = "Find Order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = OrderDto.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @GetMapping("/order/{id}")
    ResponseEntity<OrderDto> getOrderById(@ApiParam(required = true) @PathVariable(value = "id") Long OrderId);

    //******************************************************************************************************************
    @Operation(summary = "Update a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @PutMapping("/order/{id}")
    ResponseEntity updateOrder(@ApiParam(required = true) @PathVariable(value = "id") Long orderId,
                               @ApiParam(required = true) @Validated @RequestBody
                                       OrderRequest orderRequest);

    //******************************************************************************************************************
    @Operation(summary = "Delete a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @DeleteMapping("/order/{id}")
    ResponseEntity deleteOrder(@ApiParam(required = true) @PathVariable(value = "id") Long orderId);
}
