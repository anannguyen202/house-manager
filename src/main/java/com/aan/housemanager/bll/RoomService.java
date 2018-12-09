package com.aan.housemanager.bll;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aan.housemanager.dal.RoomDao;
import com.aan.housemanager.dal.RoomTypeDao;
import com.aan.housemanager.dal.UserDao;
import com.aan.housemanager.dto.HeroDto;
import com.aan.housemanager.dto.ProfileDto;
import com.aan.housemanager.dto.RHDto;
import com.aan.housemanager.dto.RHDto2;
import com.aan.housemanager.model.Room;
import com.aan.housemanager.model.Users;

import ch.qos.logback.classic.Logger;

@Service(value = "roomService")
@Transactional
public class RoomService {
	// region -- Fields --

    private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(RoomService.class);

	@Autowired
	private RoomDao roomDao;

	// end

	// region -- Methods --
	
	public List<RHDto> getRoomsWithCheckIn() {
		List<RHDto> res = new ArrayList<>();
		
		List<Object[]> list = roomDao.getRoomsWithCheckIn();
		for (Object[] i : list) {
			
			Integer historyId = (Integer) i[4];
			
			RHDto2 c = null;

			if(historyId != null) {
				Object[] a = roomDao.getCheckin(historyId);
				c = new RHDto2();
				c.setInDate((Timestamp) a[0]);				
			}
			
			RHDto t = new RHDto();
			t.setRoomId((Integer) i[0]);
			t.setRoomNumber((Integer) i[1]);
			t.setTypeId((String) i[2]);
			t.setStatusId((String) i[3]);
			t.setHistoryId((Integer) i[4]);
			t.setCheckIn(c);
			res.add(t);
		}
		
		return res;
	}

	public Room getBy(int id) {
		Room res = roomDao.getBy(id);
		return res;
	}

	public List<Room> getRooms() {
		List<Room> res = roomDao.getRooms();
		return res;
	}

	public String save(Room m) {
		String res = "";

		Integer id = m.getRoomId();

		Room m1;
		
		if (id == null || id == 0) {
			roomDao.save(m);
	
		} else {
			m1 = roomDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				roomDao.save(m1);
			}
		}

		return res;
	}

	public String delete(int id) {
		String res = "";

		Room m = roomDao.getBy(id);
		if (m != null) {
//			m.setDeleted(true);
			roomDao.delete(m);
		}

		return res;
	}

}