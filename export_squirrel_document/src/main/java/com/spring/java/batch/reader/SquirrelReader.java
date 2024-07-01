package com.spring.java.batch.reader;

import com.spring.java.batch.dao.SquirrelDao;
import com.spring.java.batch.entity.SquirrelEntity;
import java.util.Iterator;
import java.util.stream.Stream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.stereotype.Component;

@Component
public class SquirrelReader extends AbstractItemCountingItemStreamItemReader<SquirrelEntity> {
  private final SquirrelDao squirrelDao;
  private Stream<SquirrelEntity> stream;
  private Iterator<SquirrelEntity> iterator;

  public SquirrelReader(SquirrelDao squirrelDao) {
    super.setName(this.getClass().getSimpleName());
    this.squirrelDao = squirrelDao;
  }

  @Override
  protected SquirrelEntity doRead() throws Exception {
    return iterator.hasNext() ? iterator.next() : null;
  }

  @Override
  protected void doOpen() throws Exception {
    stream = squirrelDao.findAll();
    iterator = stream.iterator();
  }

  @Override
  protected void doClose() throws Exception {
    stream.close();
  }
}
