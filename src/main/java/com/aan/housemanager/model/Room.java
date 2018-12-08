package com.aan.housemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room", schema = "public")
public class Room {
	// region -- Fields --
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_id_seq_generator")
	@SequenceGenerator(name = "room_id_seq_generator", sequenceName = "public.room_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer roomId;
	
	@Column(columnDefinition = "INT4", name = "room_number")
	private Integer roomNumber;
	
	@Column(columnDefinition = "varchar(3)", name = "status_id")
	private String statusId;
	
	// end

	// region -- Get set --

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	// end

	// region -- Methods --

	public Room() {

	}

	// end
	
	
	
}
