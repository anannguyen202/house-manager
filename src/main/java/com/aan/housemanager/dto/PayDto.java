/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayDto {
	// region -- Fields --

	@JsonProperty(value = "roomId")
	private Integer roomId;

	@JsonProperty(value = "inDate")
	private Date inDate;

	@JsonProperty(value = "typeId")
	private String typeId;

	@JsonProperty(value = "hourPrice")
	private Double hourPrice;
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
	
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Double getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(Double hourPrice) {
		this.hourPrice = hourPrice;
	}

	// end

	// region -- Methods --

	public PayDto() {

	}

	// end
}