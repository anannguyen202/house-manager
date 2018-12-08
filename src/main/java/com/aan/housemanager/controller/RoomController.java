/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aan.housemanager.bll.RoomHistoryService;
import com.aan.housemanager.bll.RoomService;
import com.aan.housemanager.bll.UserService;
import com.aan.housemanager.common.Utils;
import com.aan.housemanager.dto.PayloadDto;
import com.aan.housemanager.dto.RHDto;
import com.aan.housemanager.model.Room;
import com.aan.housemanager.model.RoomHistory;
import com.aan.housemanager.model.Users;
import com.aan.housemanager.req.RoomHistoryReq;
import com.aan.housemanager.req.UserSignInReq;
import com.aan.housemanager.req.UserSignUpReq;
import com.aan.housemanager.rsp.MultipleRsp;
import com.aan.housemanager.rsp.SingleRsp;

import java.util.List;


@RestController
@RequestMapping("/room")
public class RoomController {
	// region -- Fields --

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomHistoryService roomHistoryService;

	// end

	// region -- Methods --
	@RequestMapping(value = "/get-av", method = RequestMethod.GET)
	public ResponseEntity<?> getRoomsWithCheckIn(@RequestHeader HttpHeaders header) {
		MultipleRsp res = new MultipleRsp();

		try {
			// Handle
			List<RHDto> m = roomService.getRoomsWithCheckIn();
			
			Map<String, Object> data = new LinkedHashMap<>();
	
			data.put("list", m);
		
			res.setResult(data);
			
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<?> getHeroes(@RequestHeader HttpHeaders header) {
		MultipleRsp res = new MultipleRsp();

		try {
			// Handle
			List<Room> m = roomService.getRooms();
			
			Map<String, Object> data = new LinkedHashMap<>();
	
			data.put("list", m);
		
			res.setResult(data);
			
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getHero(
			@RequestHeader HttpHeaders header, 
			@PathVariable("id") int id
		) {
		SingleRsp res = new SingleRsp();

		try {
			PayloadDto pl = Utils.getTokenInfor(header);
			int userId = pl.getId();
			
			// Handle
			Room m = roomService.getBy(id);
		
			res.setResult(m);
			
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addHero(@RequestBody RoomHistoryReq req) {
		SingleRsp res = new SingleRsp();
		
		// Get data
//		String name = req.getName();

		// Convert data
		Room m = new Room();
//		m.setName(name);

		try {
			// Handle
			String tmp = roomService.save(m);

			if (tmp.isEmpty()) {
				// Set Data
				res.setResult(tmp);
				res.setMessage("Add success!");
			} else {
				res.setError("have already!");
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteHero(@RequestBody RoomHistoryReq req) {
		SingleRsp res = new SingleRsp();
		
		// Get data
		int id = req.getId();

		try {
			// Handle
			String tmp = roomService.delete(id);

			if (tmp.isEmpty()) {
				// Set Data
				res.setResult(tmp);
				res.setMessage("Delete success!");
			} else {
				res.setError("have already!");
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	// end
}