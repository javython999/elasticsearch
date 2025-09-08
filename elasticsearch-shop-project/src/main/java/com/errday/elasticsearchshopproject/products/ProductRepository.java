package com.errday.elasticsearchshopproject.products;

import com.errday.elasticsearchshopproject.products.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
