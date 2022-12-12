package com.example.myselectshop.entity;

import com.example.myselectshop.entity.Product;
import com.example.myselectshop.dto.ProductRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// (1)
class ProductTest {
    @Test // (2)
    @DisplayName("정상 케이스") // (3)
    void createProduct_Normal() {
        // (4) given - 준비!
        Long userId = 100L;
        String title = "오리온 꼬북칩 초코츄러스맛 160g";
        String image = "https://shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";
        String link = "https://search.shopping.naver.com/gate.nhn?id=24161228524";
        int lprice = 2350;

        ProductRequestDto requestDto = new ProductRequestDto(
                title,
                image,
                link,
                lprice
        );

        // (5) when - 테스트하려는 로직 수행!
        Product product = new Product(requestDto, userId);

        // (6) then - 검증!
        assertNull(product.getId()); // (6-a)
        assertEquals(userId, product.getUserId()); // (6-b)
        assertEquals(title, product.getTitle());
        assertEquals(image, product.getImage());
        assertEquals(link, product.getLink());
        assertEquals(lprice, product.getLprice());
        assertEquals(0, product.getMyprice());
    }

}