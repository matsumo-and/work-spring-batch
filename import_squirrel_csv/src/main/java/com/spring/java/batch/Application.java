package com.spring.java.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired private JobLauncher jobLauncher;

  @Autowired private Job squirrelJob;

  public static void main(String[] args) throws Exception {
    System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
  }

  @Override
  public void run(String... args) throws Exception {
    jobLauncher.run(squirrelJob, new JobParametersBuilder().toJobParameters());
  }
}
