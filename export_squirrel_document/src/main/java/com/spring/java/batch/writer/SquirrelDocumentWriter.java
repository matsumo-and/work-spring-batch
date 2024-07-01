package com.spring.java.batch.writer;

import com.spring.java.batch.dao.DocumentRepository;
import com.spring.java.batch.entity.SquirrelDocumentEntity;
import java.util.List;
import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;

@Component
public class SquirrelDocumentWriter implements ItemWriter<SquirrelDocumentEntity> {
  private final DocumentRepository repository;

  public SquirrelDocumentWriter(DocumentRepository repository) {
    this.repository = repository;
  }

  @Override
  public void write(Chunk<? extends SquirrelDocumentEntity> chunk) throws Exception {
    repository.saveAll((List<SquirrelDocumentEntity>) chunk.getItems());
  }
}
