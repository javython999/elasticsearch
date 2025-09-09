package com.errday.elasticsearchshopproject.products;

import com.errday.elasticsearchshopproject.products.domain.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, String> {
}
