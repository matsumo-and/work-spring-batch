package com.spring.java.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "squirrel")
@Data
@AllArgsConstructor
public class SquirrelDocumentEntity {

  @Field("area_name")
  private String areaName;

  @Field("area_id")
  private String areaId;

  @Field("park_name")
  private String parkName;

  @Field("park_id")
  private String parkId;

  @Id
  @Field("squirrel_id")
  private String squirrelId;

  @Field("primary_fur_code")
  private String primaryFurCode;

  @Field("highlights_in_fur_color")
  private String highlightsInFurColor;

  @Field("color_notes")
  private String colorNotes;

  @Field("location")
  private String location;

  @Field("above_ground")
  private String aboveGround;

  @Field("specific_location")
  private String specificLocation;

  @Field("activities")
  private String activities;

  @Field("interactions_with_humans")
  private String interactionsWithHumans;

  @Field("observations")
  private String observations;

  @Field("squirrel_latitude")
  private String squirrelLatitude;

  @Field("squirrel_longitude")
  private String squirrelLongitude;
}
