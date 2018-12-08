package com.aan.housemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room_type", schema = "public")
public class RoomType {
	// region -- Fields --
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_type_id_seq_generator")
	@SequenceGenerator(name = "room_type_id_seq_generator", sequenceName = "public.room_type_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;
	
	@Column(columnDefinition = "VARCHAR(64)", name = "name")
	private String name;
	
	@Column(columnDefinition = "varchar(5)", name = "type_id")
	private String typeId;
	
	@Column(columnDefinition = "FLOAT8", name = "hour_price")
	private Float hourPrice;
	
	@Column(columnDefinition = "FLOAT8", name = "night_price")
	private Float nightPrice;
	
	@Column(columnDefinition = "FLOAT8", name = "day_price")
	private Float dayPrice;
	
	// end

	// region -- Get set --

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Float getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(Float hourPrice) {
		this.hourPrice = hourPrice;
	}

	public Float getNightPrice() {
		return nightPrice;
	}

	public void setNightPrice(Float nightPrice) {
		this.nightPrice = nightPrice;
	}

	public Float getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Float dayPrice) {
		this.dayPrice = dayPrice;
	}

	// end

	// region -- Methods --

	public RoomType() {

	}

	
	// end
}
