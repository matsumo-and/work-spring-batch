package com.spring.java.batch.tasklet;

import com.spring.java.batch.dao.DocumentRepository;
import com.spring.java.batch.entity.SquirrelDocumentEntity;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

@Component
public class DeleteIndexTasklet implements Tasklet {
  private final ElasticsearchOperations operations;

  public DeleteIndexTasklet(ElasticsearchOperations operations, DocumentRepository repository) {
    this.operations = operations;
  }

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    operations.indexOps(SquirrelDocumentEntity.class).delete();
    return RepeatStatus.FINISHED;
  }
}
