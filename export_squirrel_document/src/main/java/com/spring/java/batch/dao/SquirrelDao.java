package com.spring.java.batch.dao;

import com.spring.java.batch.entity.SquirrelEntity;
import java.util.stream.Stream;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
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
}
