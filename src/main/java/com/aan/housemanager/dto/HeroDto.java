/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroDto {
	// region -- Fields --

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "name")
	private String name;

	// end

	// region -- Get set --

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// end

	// region -- Methods --

	public HeroDto() {

	}

	// end
}