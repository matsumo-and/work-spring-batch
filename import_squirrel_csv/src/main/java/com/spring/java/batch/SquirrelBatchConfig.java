package com.spring.java.batch;

import com.spring.java.batch.entity.SquirrelCsvEntity;
import com.spring.java.batch.entity.SquirrelEntity;
import com.spring.java.batch.listener.LoggingListener;
import com.spring.java.batch.processor.SquirrelProcessor;
import com.spring.java.batch.tasklet.SquirrelTruncateTasklet;
import com.spring.java.batch.writer.SquirrelWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@EnableBatchProcessing
@Configuration
public class SquirrelBatchConfig {

  static final String CSV_PATH = "/squirrel.csv";

  private final SquirrelProcessor squirrelProcessor;
  private final SquirrelWriter squirrelWriter;
  private final LoggingListener loggingListener;
  private final SquirrelTruncateTasklet squirrelTruncateTasklet;

  public SquirrelBatchConfig(
      SquirrelProcessor squirrelProcessor,
      SquirrelWriter squirrelWriter,
      LoggingListener loggingListener,
      SquirrelTruncateTasklet squirrelTruncateTasklet) {
    this.squirrelProcessor = squirrelProcessor;
    this.squirrelWriter = squirrelWriter;
    this.loggingListener = loggingListener;
    this.squirrelTruncateTasklet = squirrelTruncateTasklet;
  }

  @Bean
  public Job squirrelJob(JobRepository jobRepository, Step truncateStep, Step squirrelStep) {
    return new JobBuilder("squirrelJob", jobRepository)
        .start(truncateStep)
        .next(squirrelStep)
        .build();
  }

  @Bean
  public Step truncateStep(
      JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("squirrelStep", jobRepository)
        .tasklet(squirrelTruncateTasklet, transactionManager)
        .build();
  }

  @Bean
  public Step squirrelStep(
      JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("squirrelStep", jobRepository)
        .<SquirrelCsvEntity, SquirrelEntity>chunk(100, transactionManager)
        .reader(reader())
        .processor(squirrelProcessor)
        .writer(squirrelWriter)
        .listener(loggingListener)
        .build();
  }

  @Bean
  public FlatFileItemReader<SquirrelCsvEntity> reader() {
    return new FlatFileItemReaderBuilder<SquirrelCsvEntity>()
        .name("squirrelReader")
        .resource(new ClassPathResource(CSV_PATH))
        .linesToSkip(1)
        .delimited()
        .names(
            "areaName",
            "areaId",
            "parkName",
            "parkId",
            "squirrelId",
            "primaryFurCode",
            "highlightsInFurColor",
            "colorNotes",
            "location",
            "aboveGround",
            "specificLocation",
            "activities",
            "interactionsWithHumans",
            "observations",
            "squirrelLatitude",
            "squirrelLongitude")
        .fieldSetMapper(
            new BeanWrapperFieldSetMapper<SquirrelCsvEntity>() {
              {
                setTargetType(SquirrelCsvEntity.class);
              }
            })
        .build();
  }
}
