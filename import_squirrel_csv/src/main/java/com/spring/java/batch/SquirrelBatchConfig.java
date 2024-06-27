package com.spring.java.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@EnableBatchProcessing
@Configuration
public class SquirrelBatchConfig {

  private final SquirrelReader squirrelReader;
  private final SquirrelProcessor squirrelProcessor;
  private final SquirrelWriter squirrelWriter;

  public SquirrelBatchConfig(
      SquirrelReader squirrelReader,
      SquirrelProcessor squirrelProcessor,
      SquirrelWriter squirrelWriter) {
    this.squirrelReader = squirrelReader;
    this.squirrelProcessor = squirrelProcessor;
    this.squirrelWriter = squirrelWriter;
  }

  @Bean
  public Job squirrelJob(JobRepository jobRepository, Step squirrelStep) {
    return new JobBuilder("squirrelJob", jobRepository).start(squirrelStep).build();
  }

  @Bean
  public Step squirrelStep(
      JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("squirrelStep", jobRepository).chunk(100)
        .reader(squirrelReader)
        .processor(squirrelProcessor)
        .writer(squirrelWriter)
        .build();
  }
}
