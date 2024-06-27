package com.spring.java.batch;

import org.springframework.batch.item.*;
import org.springframework.lang.NonNull;

public class SquirrelProcessor implements ItemProcessor<Object, SquirrelEntity> {

  @Override
  public SquirrelEntity process(@NonNull Object item) throws Exception {
    return null;
  }
}
