package com.spring.java.batch;

import java.util.List;
import java.util.stream.Stream;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;

@Dao
@ConfigAutowireable
public interface SquirrelDao {

  @Select
  @Sql(
      """
            select *
            from squirrel
            """)
  Stream<SquirrelEntity> findAll();

  @BatchInsert
  BatchResult<SquirrelEntity> insert(List<SquirrelEntity> squirrelEntityList);
}
