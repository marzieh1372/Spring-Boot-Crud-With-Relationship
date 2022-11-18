package com.chpaar.controller;

import com.chpaar.api.ProductAPI;
import com.chpaar.model.dto.ProductRequest;
import com.chpaar.model.dto.ProductResponse;
import com.chpaar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductController implements ProductAPI {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        return new ResponseEntity<List<ProductResponse>>(productService.getAllProduct(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {
        ProductResponse customerResponse = productService.saveProduct(productRequest);
        return new ResponseEntity<ProductResponse>(customerResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductResponse> getProductById(Long productId) {
        return new ResponseEntity<ProductResponse>(productService.getProductById(productId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateProduct(Long productId,ProductRequest productRequest) {
        productService.updateProduct(productId,productRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity deleteProduct(Long productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
