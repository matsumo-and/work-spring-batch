package com.spring.java.batch;

import java.util.OptionalLong;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Table(name = "squirrel")
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public record SquirrelEntity(
    @Id String squirrelId,
    String areaName,
    String areaId,
    String parkName,
    String parkId,
    String primaryFurCode,
    String highlightsInFurColor,
    String colorNotes,
    String location,
    OptionalLong aboveGround,
    String specificLocation,
    String activities,
    String interactionsWithHumans,
    String observations,
    String squirrelLatitude,
    String squirrelLongitude) {}
