package com.aan.housemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room_status", schema = "public")
public class RoomStatus {
	// region -- Fields --
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_status_id_seq_generator")
	@SequenceGenerator(name = "room_status_id_seq_generator", sequenceName = "public.room_status_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;
	
	@Column(columnDefinition = "VARCHAR(64)", name = "name")
	private String name;
	
	@Column(columnDefinition = "varchar(3)", name = "status_id")
	private String statusId;
	
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

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	// end

	// region -- Methods --
	
	public RoomStatus() {

	}

	
	// end
}
