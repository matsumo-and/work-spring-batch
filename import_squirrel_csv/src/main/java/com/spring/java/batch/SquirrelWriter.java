package com.spring.java.batch;

import java.util.List;
import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;

@Component
public class SquirrelWriter implements ItemWriter<SquirrelEntity> {

  private final SquirrelDao squirrelDao;

  public SquirrelWriter(SquirrelDao squirrelDao) {
    this.squirrelDao = squirrelDao;
  }

  @Override
  public void write(Chunk<? extends SquirrelEntity> chunk) throws Exception {
    squirrelDao.insert((List<SquirrelEntity>) chunk.getItems());
  }
}
