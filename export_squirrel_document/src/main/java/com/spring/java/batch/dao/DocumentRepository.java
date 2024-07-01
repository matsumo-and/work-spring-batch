package com.spring.java.batch.dao;

import com.spring.java.batch.entity.SquirrelDocumentEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DocumentRepository extends ElasticsearchRepository<SquirrelDocumentEntity, Long> {}
