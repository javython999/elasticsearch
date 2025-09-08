package com.errday.elasticsearchshopproject.products;

import com.errday.elasticsearchshopproject.products.domain.Product;
import com.errday.elasticsearchshopproject.products.dto.CreateProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getProducts(page, size));
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
