/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aan.housemanager.model.RoomType;

import java.util.List;

public interface RoomTypeDao extends CrudRepository<RoomType, Integer> {
	
	@Query("FROM RoomType r WHERE r.id = :id")
	public RoomType getBy(@Param("id") int id);
	
	@Query("FROM RoomType r WHERE r.typeId = :typeId")
	public RoomType getBy(@Param("typeId") String typeId);
	
	@Query("FROM RoomType")
	public List<RoomType> getRoomTypes();
	
}