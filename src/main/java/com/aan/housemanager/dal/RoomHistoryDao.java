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

import com.aan.housemanager.model.RoomHistory;

import java.util.List;

public interface RoomHistoryDao extends CrudRepository<RoomHistory, Integer> {
	
	@Query("FROM RoomHistory h WHERE h.id = :id")
	public RoomHistory getBy(@Param("id") int id);
	
	@Query("FROM RoomHistory")
	public List<RoomHistory> getRoomHistorys();
	
}