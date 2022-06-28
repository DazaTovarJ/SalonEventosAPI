/**
 * Author:  jdaza
 * Created: 24 Jun 2022
 */
CREATE DATABASE events_room;

USE events_room;

CREATE TABLE events(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    event_type ENUM("Birthday", "Graduation", "Wedding") NOT NULL,
    guests INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP,
    state INT NOT NULL DEFAULT 1,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);
