package com.spring.java.batch.dao;

import java.util.List;
import java.util.stream.Stream;

import com.spring.java.batch.entity.SquirrelEntity;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;
import org.seasar.doma.message.Message;

@Dao
@ConfigAutowireable
public interface SquirrelDao {

  @Select
  @Suppress(messages = {Message.DOMA4274})
  @Sql(
      """
            select *
            from squirrel
            """)
  Stream<SquirrelEntity> findAll();

  @Delete
  @Sql(
      """
              truncate table squirrel
              """)
  int truncate();

  @BatchInsert
  BatchResult<SquirrelEntity> insert(List<SquirrelEntity> squirrelEntityList);
}
