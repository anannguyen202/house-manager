/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RHDto2 {
	// region -- Fields --

	@JsonProperty(value = "inDate")
	private Timestamp inDate;

	// end

	// region -- Get set --

	public Timestamp getInDate() {
		return inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}


	// end

	// region -- Methods --

	public RHDto2() {

	}

	// end
}