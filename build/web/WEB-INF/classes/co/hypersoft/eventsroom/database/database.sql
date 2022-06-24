/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jdaza
 * Created: 24 Jun 2022
 */
CREATE DATABASE events_room;

USE events_room;

CREATE TABLE events(
	id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    event_type ENUM("Cumpleaños", "Grado", "Matrimonio"),
    guests INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    state INT NOT NULL DEFAULT 1,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);
