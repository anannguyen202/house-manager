package com.aan.housemanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "room_history", schema = "public")
public class RoomHistory {
	// region -- Fields --
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_history_id_seq_generator")
	@SequenceGenerator(name = "room_history_id_seq_generator", sequenceName = "public.room_history_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", name = "in_date")
	private Date inDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", name = "out_date")
	private Date outDate;
	
	@Column(columnDefinition = "INT4", name = "room_id")
	private Integer roomId;
	
	@Column(columnDefinition = "VARCHAR(5)", name = "type_id")
	private String typeId;
	
	@Column(columnDefinition = "VARCHAR(256)", name = "description")
	private String description;

	@Column(columnDefinition = "BOOLEAN")
	private boolean isDeleted;
	
	// end

	// region -- Get set --

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getInDate() {
		return inDate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// end

	// region -- Methods --

	public RoomHistory() {

	}

	// end
	
	
	
}
