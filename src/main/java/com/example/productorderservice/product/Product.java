package com.example.productorderservice.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private  DiscountPolicy discountPolicy;
    private  int price;

    // @NoArgsConstructor 랑 별개임 .. 위에서 Protedted로 막은건 jpa이외에 기본 생성자로 생성을 막기위함이고
    // 아래 생성자는 ProductService에서 상품을 생성할 때 사용하기 위한 생성자임
    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;

    }

}
