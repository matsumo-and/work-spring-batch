package com.spring.java.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.stereotype.Component;

@Component
public class LoggingListener implements JobExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(LoggingListener.class);

  @AfterJob
  @Override
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      System.out.println("[INFO] JOB FINISHED ");
      log.info("[INFO] JOB FINISHED ");
    } else {
      System.out.println("[INFO] JOB FINISHED with NOT COMPLETED");
      log.info("[INFO] JOB FINISHED with NOT COMPLETED");
    }
  }
}
