INSERT INTO PUBLIC."room_type" ("name", "type_id", "hour_price", "night_price", "day_price") VALUES
	('Phòng đơn máy quạt', 'P1-MQ', 50000, 100000, 150000),
	('Phòng đơn máy lạnh', 'P1-ML', 50000, 100000, 150000),
	('Phòng đôi máy quạt', 'P2-MQ', 50000, 100000, 150000),
	('Phòng đôi máy lạnh', 'P2-ML', 50000, 100000, 150000);
		
INSERT INTO PUBLIC."room_status" ("status_id","name") VALUES
	('AVA','Phòng trống'),
	('ACT','Có khách'),
	('CLE','Chờ dọn dẹp');
	
INSERT INTO PUBLIC."room" ("room_number","status_id") VALUES
	(1,'AVA'),
	(2,'AVA'),
	(3,'AVA'),
	(4,'AVA'),
	(5,'AVA');