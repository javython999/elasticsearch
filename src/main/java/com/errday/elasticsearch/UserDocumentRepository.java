package com.errday.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {
}
