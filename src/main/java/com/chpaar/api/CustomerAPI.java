package com.chpaar.api;

import com.chpaar.model.dto.CustomerRequest;
import com.chpaar.model.dto.CustomerResponse;
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

@Api(tags = "Customer Api")
@Tag(name = "Customer")
@RequestMapping("/v1")
public interface CustomerAPI {

    @Operation(summary = "Get all Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!", content =
                    {@Content(mediaType = "application/json"
                            , array = @ArraySchema(schema = @Schema(implementation = CustomerResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)})
    @GetMapping("/customers")
    ResponseEntity<List<CustomerResponse>> getAllCustomer();

    //******************************************************************************************************************
    @Operation(summary = "Add a New Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = CustomerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input")
            })
    //, @ApiResponse(responseCode = "409", description = "This Customer already exists")
    @PostMapping("/customer")
    ResponseEntity<CustomerResponse> createCustomer(@ApiParam(required = true)
                                                    @Validated @RequestBody CustomerRequest customerRequest);

    //******************************************************************************************************************
    @Operation(summary = "Find customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!",
                    content = {@Content(mediaType = "application/json"
                            , schema = @Schema(implementation = CustomerResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @GetMapping("/customer/{id}")
    ResponseEntity<CustomerResponse> getCustomerById(@ApiParam(required = true) @PathVariable(value = "id")
                                                             Long CustomerId);

    //******************************************************************************************************************
    @Operation(summary = "Update a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @PutMapping("/customer/{id}")
    ResponseEntity updateCustomer(@ApiParam(required = true) @PathVariable(value = "id") Long customerId,
                                  @ApiParam(required = true) @Validated @RequestBody CustomerRequest customerRequest);

    //******************************************************************************************************************
    @Operation(summary = "Delete a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    @DeleteMapping("/customer/{id}")
    ResponseEntity deleteCustomer(@ApiParam(required = true) @PathVariable(value = "id") Long customerId);
}
