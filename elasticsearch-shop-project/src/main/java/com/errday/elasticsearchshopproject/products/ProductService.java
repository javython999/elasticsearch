package com.errday.elasticsearchshopproject.products;

import com.errday.elasticsearchshopproject.products.domain.Product;
import com.errday.elasticsearchshopproject.products.dto.CreateProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return productRepository.findAll(pageable).getContent();
    }

    public Product createProduct(CreateProductRequestDto request) {
        Product product = new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getRating(),
                request.getCategory()
        );

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
