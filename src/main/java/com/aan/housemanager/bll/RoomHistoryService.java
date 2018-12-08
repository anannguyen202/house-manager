package com.aan.housemanager.bll;

import java.util.ArrayList;
import java.util.Date;
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
import com.aan.housemanager.dal.RoomHistoryDao;
import com.aan.housemanager.dal.RoomTypeDao;
import com.aan.housemanager.dal.UserDao;
import com.aan.housemanager.dto.HeroDto;
import com.aan.housemanager.dto.ProfileDto;
import com.aan.housemanager.model.Room;
import com.aan.housemanager.model.RoomHistory;
import com.aan.housemanager.model.Users;

import ch.qos.logback.classic.Logger;

@Service(value = "roomHistoryService")
@Transactional
public class RoomHistoryService {
	// region -- Fields --

	@Autowired
	private RoomHistoryDao roomHistoryDao;

	// end

	// region -- Methods --

	public String checkOut(RoomHistory m) {

		Integer id = m.getId();
		String res = "";
		
		if(id == null || id == 0) return res = "Id null";

		RoomHistory m1 = roomHistoryDao.getBy(id);
		
		if (m1 == null) return res = "Id does not exist";
		
		if (m1.isDeleted()) return res = "This is deleted";
			
		m1.setOutDate(new Date());
		m1.setDeleted(true);
		roomHistoryDao.save(m1);
		
		return res;
	}
	

	public RoomHistory getBy(int id) {
		RoomHistory res = roomHistoryDao.getBy(id);
		return res;
	}

	public List<RoomHistory> getAll() {
		List<RoomHistory> res = roomHistoryDao.getRoomHistorys();
		return res;
	}

	public String save(RoomHistory m) {
		String res = "";

		Integer id = m.getId();

		RoomHistory m1;
		
		if (id == null || id == 0) {			
			roomHistoryDao.save(m);
		} else {
			m1 = roomHistoryDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				roomHistoryDao.save(m1);
			}
		}

		return res;
	}

	public String delete(int id) {
		String res = "";

		RoomHistory m = roomHistoryDao.getBy(id);
		if (m != null) {
//			m.setDeleted(true);
			roomHistoryDao.delete(m);
		}

		return res;
	}

}