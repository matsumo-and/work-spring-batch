package com.spring.java.batch.entity;

import lombok.Data;

@Data
public class SquirrelCsvEntity {
  private String areaName;
  private String areaId;
  private String parkName;
  private String parkId;
  private String squirrelId;
  private String primaryFurCode;
  private String highlightsInFurColor;
  private String colorNotes;
  private String location;
  private String aboveGround;
  private String specificLocation;
  private String activities;
  private String interactionsWithHumans;
  private String observations;
  private String squirrelLatitude;
  private String squirrelLongitude;
}
