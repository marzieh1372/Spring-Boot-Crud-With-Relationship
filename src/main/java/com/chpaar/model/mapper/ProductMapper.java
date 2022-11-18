package com.chpaar.model.mapper;

import com.chpaar.model.dto.ProductRequest;
import com.chpaar.model.dto.ProductResponse;
import com.chpaar.model.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract Product mapProductRequestToProduct(ProductRequest productRequest);
    public abstract ProductRequest mapProductToProductRequest(Product product);
    public abstract ProductResponse mapProductToProductResponse(Product product);
    public abstract List<ProductResponse> mapProductListToProductResponse(List<Product> products);
}
