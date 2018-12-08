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

public class GetCheckInReq {
	// region -- Fields --

	@JsonProperty(value = "id")
	private int id;
	
	// end
	
	// region -- Get set --

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// end
	
	// region -- Methods --
	
	public GetCheckInReq() {
		
	}

	// end
}