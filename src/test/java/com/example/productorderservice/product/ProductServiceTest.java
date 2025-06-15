package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository=new ProductRepository();
        productPort= new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    // 요청을 전달받아서 상품을 등록
    @Test
    void 상픔등록(){
        final AddProductRequest request = 상품등록요청_생성();
        productService.addProduct(request);
    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1234;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }

}
