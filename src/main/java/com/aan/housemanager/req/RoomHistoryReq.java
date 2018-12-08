/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.req;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomHistoryReq {
	// region -- Fields --

	@JsonProperty(value = "id")
	private int id;
	
	@JsonProperty(value = "roomId")
	private int roomId;
	
	@JsonProperty(value = "typeId")
	private String typeId;

	@JsonProperty(value = "inDate")
	private Date inDate;

	@JsonProperty(value = "description")
	private String description;

	// end
	
	// region -- Get set --

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public void setRoomId(int roomId) {
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
	
	public RoomHistoryReq() {
		
	}

	// end
}