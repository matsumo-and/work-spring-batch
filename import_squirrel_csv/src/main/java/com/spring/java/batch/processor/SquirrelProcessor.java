package com.spring.java.batch.processor;

import java.util.OptionalLong;

import com.spring.java.batch.entity.SquirrelCsvEntity;
import com.spring.java.batch.entity.SquirrelEntity;
import org.springframework.batch.item.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SquirrelProcessor implements ItemProcessor<SquirrelCsvEntity, SquirrelEntity> {

  @Override
  public SquirrelEntity process(@NonNull SquirrelCsvEntity csvEntity) {
    return new SquirrelEntity(
        csvEntity.getSquirrelId(),
        csvEntity.getAreaName(),
        csvEntity.getAreaId(),
        csvEntity.getParkName(),
        csvEntity.getParkId(),
        csvEntity.getPrimaryFurCode(),
        csvEntity.getHighlightsInFurColor(),
        csvEntity.getColorNotes(),
        csvEntity.getLocation(),
        convertAboveGround(csvEntity.getAboveGround()),
        csvEntity.getSpecificLocation(),
        csvEntity.getActivities(),
        csvEntity.getInteractionsWithHumans(),
        csvEntity.getObservations(),
        csvEntity.getSquirrelLatitude(),
        csvEntity.getSquirrelLongitude());
  }

  private OptionalLong convertAboveGround(String aboveGround) {
    if (aboveGround == null) {
      return OptionalLong.empty();
    }
    try {
      int longAboveGround = Integer.parseInt(aboveGround);
      return OptionalLong.of(longAboveGround);
    } catch (Exception e) {
      return OptionalLong.empty();
    }
  }
}
