package com.example.product.controller;

import com.example.product.data.dto.ProductDto;
import com.example.product.data.entity.ProductEntity;
import com.example.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    @Operation(summary = "전체 조회", description = "전체 조회")
    public List<ProductEntity> getProducts(){
        return productService.getAllProduct();
    }
    @GetMapping("/{productId}")
    @Operation(summary = "ID로 조회", description = "ID로 조회")
    public ProductEntity getProduct(@PathVariable int productId){
        return productService.getProductById(productId);
    }
    @GetMapping("/byName")
    @Operation(summary = "이름으로 조회", description = "이름으로 조회")
    public List<ProductEntity> getProductByName(@RequestParam String keyword){
        if(keyword.isEmpty()){
            return null;
        }
        return productService.findByProductNameContaining(keyword);
    }
    @GetMapping("/byGreaterPrice")
    @Operation(summary = "기준가격 이상 조회", description = "기준가격 이상 조회")
    public List<ProductEntity> getProductByGreaterPrice(@RequestParam int value){
//        if(value > 5000000){
//            return null;
//        }
        return productService.findByProductPriceGreaterThan(value);
    }
    @GetMapping("/byLessPrice")
    @Operation(summary = "기준가격 이하 조회", description = "기준가격 이하 조회")
    public List<ProductEntity> getProductByLessPrice(@RequestParam int value){
//        if(value < 1000){
//            return null;
//        }
        return productService.findByProductPriceLessThan(value);
    }
    @GetMapping("/byBetweenPrice")
    @Operation(summary = "가격~가격 사이 조회", description = "가격~가격 사이 조회")
    public List<ProductEntity> getProductBetweenPrice(@RequestParam int value1, int value2){
//        if(value1 < 1000 || value2 > 5000000){
//            return null;
//        }
        return productService.findByProductPriceBetween(value1, value2);
    }
    @PostMapping
    @Operation(summary = "데이터 생성", description = "데이터 생성")
    public ProductEntity createProduct(@Valid @RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
    @PutMapping("/{productId}")
    @Operation(summary = "데이터 수정", description = "데이터 수정")
    public ProductEntity updateProduct(@PathVariable int productId, @Valid @RequestBody ProductDto productDto){
        return productService.updateProduct(productId, productDto);
    }
    @DeleteMapping("/{productId}")
    @Operation(summary = "데이터 삭제", description = "데이터 삭제")
    public void deleteProduct(@PathVariable int productId){
        productService.deleteProduct(productId);
    }





















}
