package com.example.productorderservice.product;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
class ProductService {


    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    // <Void> 이유 : 응답 본문이 없기 때문에 Void를 사용. ResponseEntity<T> <T>는 T 타입의 응답 본문을 포함할 수 있지만, 여기서는 본문이 없으므로 Void를 사용
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
//            throw new UnsupportedOperationException("Unsupported addProduct");
        Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
