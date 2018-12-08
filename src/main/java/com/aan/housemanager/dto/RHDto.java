/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.dto;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RHDto {
	// region -- Fields --

	@JsonProperty(value = "roomId")
	private Integer roomId;

	@JsonProperty(value = "roomNumber")
	private Integer roomNumber;

	@JsonProperty(value = "typeId")
	private String typeId;

	@JsonProperty(value = "statusId")
	private String statusId;

	@JsonProperty(value = "checkIn")
	private RHDto2 checkIn;

	// end

	// region -- Get set --

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	public RHDto2 getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(RHDto2 checkIn) {
		this.checkIn = checkIn;
	}


	// end

	// region -- Methods --

	public RHDto() {

	}

	// end
}