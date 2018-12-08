DROP TABLE IF EXISTS PUBLIC."room";
CREATE TABLE PUBLIC."room"
(
	"room_id"				SERIAL PRIMARY KEY,
	"room_number"			INT4,
	"status_id"				VARCHAR(3),
	"history_id"			INT4
);

DROP TABLE IF EXISTS PUBLIC."room_status";
CREATE TABLE PUBLIC."room_status"
(
	"id"					SERIAL PRIMARY KEY,
	"status_id"				VARCHAR(3),
	"name"					VARCHAR(64)
);

DROP TABLE IF EXISTS PUBLIC."room_type";
CREATE TABLE PUBLIC."room_type"
(
	"id"					SERIAL PRIMARY KEY,
	"name"					VARCHAR(64),
	"type_id"				VARCHAR(5),
	"hour_price"			FLOAT8,
	"night_price"			FLOAT8,
	"day_price"				FLOAT8
);

DROP TABLE IF EXISTS PUBLIC."room_history";
CREATE TABLE PUBLIC."room_history"
(
	"id"					SERIAL PRIMARY KEY,
	"in_date"				TIMESTAMP,
	"out_date"				TIMESTAMP,
	"room_id"				INT4,
	"type_id"				VARCHAR(5),
	"description"			VARCHAR(256),
	"is_deleted"				BOOLEAN NOT NULL DEFAULT FALSE
);