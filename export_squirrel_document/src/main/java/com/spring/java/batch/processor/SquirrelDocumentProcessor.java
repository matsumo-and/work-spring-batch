package com.spring.java.batch.processor;

import com.spring.java.batch.entity.SquirrelDocumentEntity;
import com.spring.java.batch.entity.SquirrelEntity;
import org.springframework.batch.item.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SquirrelDocumentProcessor
    implements ItemProcessor<SquirrelEntity, SquirrelDocumentEntity> {

  @Override
  public SquirrelDocumentEntity process(@NonNull SquirrelEntity squirrelEntity) {
    return new SquirrelDocumentEntity(
        squirrelEntity.squirrelId(),
        squirrelEntity.areaName(),
        squirrelEntity.areaId(),
        squirrelEntity.parkName(),
        squirrelEntity.parkId(),
        squirrelEntity.primaryFurCode(),
        squirrelEntity.highlightsInFurColor(),
        squirrelEntity.colorNotes(),
        squirrelEntity.location(),
        squirrelEntity.aboveGround().toString(),
        squirrelEntity.specificLocation(),
        squirrelEntity.activities(),
        squirrelEntity.interactionsWithHumans(),
        squirrelEntity.observations(),
        squirrelEntity.squirrelLatitude(),
        squirrelEntity.squirrelLongitude());
  }
}
