package com.spring.java.batch.writer;

import java.util.List;

import com.spring.java.batch.dao.SquirrelDao;
import com.spring.java.batch.entity.SquirrelEntity;
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
