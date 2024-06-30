package com.spring.java.batch;

import java.util.List;
import java.util.stream.Stream;
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

  @Sql(
      """
          truncate table squirrel
          """)
  void truncate();

  @BatchInsert
  BatchResult<SquirrelEntity> insert(List<SquirrelEntity> squirrelEntityList);
}
