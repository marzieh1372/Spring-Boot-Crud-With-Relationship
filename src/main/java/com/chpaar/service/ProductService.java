package com.chpaar.service;

import com.chpaar.exceptions.ResourceNotFoundException;
import com.chpaar.model.dto.ProductRequest;
import com.chpaar.model.dto.ProductResponse;
import com.chpaar.model.entity.Product;
import com.chpaar.model.mapper.ProductMapper;
import com.chpaar.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepo;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepo,ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> getAllProduct() {
        return productMapper.mapProductListToProductResponse(productRepo.findAll());
    }

    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product=productMapper.mapProductRequestToProduct(productRequest);
        return productMapper.mapProductToProductResponse(productRepo.save(product));
    }

    public ProductResponse getProductById(Long id) {
         return productMapper.mapProductToProductResponse(findProductById(id));
    }

    private Product findProductById(Long id) {
        return productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("no product found"));
    }


    //TODO change base on order
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

    public void updateProduct(Long productId, ProductRequest productRequest) {
        Product findProduct = findProductById(productId);
        findProduct.setName(productRequest.getName());
        findProduct.setPrice(productRequest.getPrice());
        productRepo.save(findProduct);
    }
}
