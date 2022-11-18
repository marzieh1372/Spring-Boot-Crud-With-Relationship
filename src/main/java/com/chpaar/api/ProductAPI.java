package com.chpaar.api;


import com.chpaar.model.dto.ProductRequest;
import com.chpaar.model.dto.ProductResponse;
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

@Api(tags = "Product Api")
@Tag(name = "Product")
@RequestMapping("/v1")
public interface ProductAPI {

    @Operation(summary = "Get all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!", content =
                    {@Content(mediaType = "application/json"
                            , array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)})
    @GetMapping("/products")
    ResponseEntity<List<ProductResponse>> getAllProduct();

    //******************************************************************************************************************
    @Operation(summary = "Add a New Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = ProductResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input")
            , @ApiResponse(responseCode = "409", description = "This Product already exists")})
    @PostMapping("/product")
    ResponseEntity<ProductResponse> createProduct(@ApiParam(required = true) @Validated @RequestBody
                                                          ProductRequest productRequest);

    //******************************************************************************************************************
    @Operation(summary = "Find product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = ProductResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @GetMapping("/product/{id}")
    ResponseEntity<ProductResponse> getProductById(@ApiParam(required = true) @PathVariable(value = "id") Long productId);

    //******************************************************************************************************************
    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @PutMapping("/product/{id}")
    ResponseEntity updateProduct(@ApiParam(required = true) @PathVariable(value = "id") Long productId,
                                 @ApiParam(required = true) @Validated @RequestBody ProductRequest productRequest);

    //******************************************************************************************************************
    @Operation(summary = "Delete a Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @DeleteMapping("/product/{id}")
    ResponseEntity deleteProduct(@ApiParam(required = true) @PathVariable(value = "id") Long productId);
}
