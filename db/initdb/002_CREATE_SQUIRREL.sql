CREATE TABLE squirrel (
    squirrel_id VARCHAR(255),
    area_name VARCHAR(255),
    area_id VARCHAR(255),
    park_name VARCHAR(255),
    park_id VARCHAR(255),
    primary_fur_code VARCHAR(255),
    highlights_in_fur_color VARCHAR(255),
    color_notes VARCHAR(255),
    location VARCHAR(255),
    above_ground BIGINT,
    specific_location VARCHAR(255),
    activities VARCHAR(255),
    interactions_with_humans VARCHAR(255),
    observations VARCHAR(255),
    squirrel_latitude VARCHAR(255),
    squirrel_longitude VARCHAR(255),
    PRIMARY KEY (squirrel_id)
);