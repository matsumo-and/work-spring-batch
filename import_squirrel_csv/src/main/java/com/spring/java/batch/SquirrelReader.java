package com.spring.java.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class SquirrelReader implements ItemReader<String> {
  @Override
  public String read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    return null;
  }
}
