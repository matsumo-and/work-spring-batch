package com.spring.java.batch.tasklet;

import com.spring.java.batch.dao.SquirrelDao;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class SquirrelTruncateTasklet implements Tasklet {

  private final SquirrelDao squirrelDao;

  public SquirrelTruncateTasklet(SquirrelDao squirrelDao) {
    this.squirrelDao = squirrelDao;
  }

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    squirrelDao.truncate();
    return RepeatStatus.CONTINUABLE;
  }
}
