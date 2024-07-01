package com.spring.java.batch;

import com.spring.java.batch.entity.SquirrelDocumentEntity;
import com.spring.java.batch.entity.SquirrelEntity;
import com.spring.java.batch.listener.LoggingListener;
import com.spring.java.batch.processor.SquirrelDocumentProcessor;
import com.spring.java.batch.reader.SquirrelReader;
import com.spring.java.batch.tasklet.DeleteIndexTasklet;
import com.spring.java.batch.writer.SquirrelDocumentWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SquirrelDocumentBatchConfig {

  private final SquirrelReader reader;
  private final SquirrelDocumentProcessor processor;
  private final SquirrelDocumentWriter writer;
  private final LoggingListener listener;
  private final DeleteIndexTasklet tasklet;

  public SquirrelDocumentBatchConfig(
      SquirrelReader reader,
      SquirrelDocumentProcessor processor,
      SquirrelDocumentWriter writer,
      LoggingListener listener,
      DeleteIndexTasklet tasklet) {
    this.reader = reader;
    this.processor = processor;
    this.writer = writer;
    this.listener = listener;
    this.tasklet = tasklet;
  }

  @Bean
  public Job elasticJob(JobRepository jobRepository, Step deleteStep, Step loadStep) {
    return new JobBuilder("elasticJob", jobRepository).start(deleteStep).next(loadStep).build();
  }

  @Bean
  public Step deleteStep(
      JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("deleteStep", jobRepository)
        .tasklet(tasklet, transactionManager)
        .allowStartIfComplete(true)
        .build();
  }

  @Bean
  public Step loadStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("squirrelStep", jobRepository)
        .<SquirrelEntity, SquirrelDocumentEntity>chunk(100, transactionManager)
        .reader(reader)
        .processor(processor)
        .writer(writer)
        .listener(listener)
        .allowStartIfComplete(true)
        .build();
  }
}
