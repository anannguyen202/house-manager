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

import com.aan.housemanager.model.Room;

import java.util.List;

public interface RoomDao extends CrudRepository<Room, Integer> {
	
	@Query("FROM Room h WHERE h.id = :id")
	public Room getBy(@Param("id") int id);
	
	@Query(nativeQuery = true, value = "select room_id, room_number, status_id from room order by room_id")
	public List<Room> getRooms();
	
	@Query(nativeQuery = true, value = "select rh.in_date from room_history rh where rh.id = :id")
	public Object[] getCheckin(@Param("id") int id);
	
	@Query(nativeQuery = true, value = "select r.room_id, r.room_number, rh.type_id, r.status_id, r.history_id, rh.in_date "
			+ "from room r left join room_history rh on r.history_id = rh.id order by room_id")
	public List<Object[]> getRoomsWithCheckIn();
	
}