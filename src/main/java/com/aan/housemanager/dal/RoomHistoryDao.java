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
	
	@Query("FROM RoomHistory WHERE id = :id")
	public RoomHistory getBy(@Param("id") int id);

	@Query(nativeQuery = true, value = "SELECT rh.id, rh.in_date, rh.room_id, rh.type_id, rt.hour_price " + 
			"FROM room_history rh " + 
			"LEFT JOIN room_type rt on rh.type_id = rt.type_id " + 
			"WHERE rh.id = :id")
	public List<Object[]> getPay(@Param("id") int id);
	
	@Query("FROM RoomHistory")
	public List<RoomHistory> getRoomHistorys();
	
}