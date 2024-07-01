package com.spring.java.batch.dao;

import com.spring.java.batch.entity.SquirrelEntity;
import java.util.List;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;

@Dao
@ConfigAutowireable
public interface SquirrelDao {

  @Delete
  @Sql(
      """
              truncate table squirrel
              """)
  int truncate();

  @BatchInsert
  BatchResult<SquirrelEntity> insert(List<SquirrelEntity> squirrelEntityList);
}
