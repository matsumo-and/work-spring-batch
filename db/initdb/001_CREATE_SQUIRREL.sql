CREATE TABLE personal_information (
    id      BIGINT          generated always as identity,
    name    VARCHAR(20)     NOT NULL,
    email   VARCHAR(50)     NOT NULL,
    url     VARCHAR(100),
    PRIMARY KEY (id)
);