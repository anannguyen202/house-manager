/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.aan.housemanager.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
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
import com.aan.housemanager.dto.PayDto;
import com.aan.housemanager.dto.PayloadDto;
import com.aan.housemanager.model.Room;
import com.aan.housemanager.model.RoomHistory;
import com.aan.housemanager.model.Users;
import com.aan.housemanager.req.GetCheckInReq;
import com.aan.housemanager.req.RoomHistoryReq;
import com.aan.housemanager.req.UserSignInReq;
import com.aan.housemanager.req.UserSignUpReq;
import com.aan.housemanager.rsp.MultipleRsp;
import com.aan.housemanager.rsp.SingleRsp;

import java.util.List;


@RestController
@RequestMapping("/room-history")
public class RoomHistoryController {
	// region -- Fields --

	@Autowired
	private RoomHistoryService roomHistoryService;

	// end

	// region -- Methods --

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	public ResponseEntity<?> getHeroes(@RequestHeader HttpHeaders header) {
		MultipleRsp res = new MultipleRsp();
		
		List<RoomHistory> m = null;

		try {
			m = roomHistoryService.getAll();
			
			Map<String, Object> data = new LinkedHashMap<>();
			
			data.put("list", m);
		
			res.setResult(data);
			
		} catch (Exception ex) {
			res.setError("Can't check-in!");
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pay/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> payRoom(
			@RequestHeader HttpHeaders header,
			@PathVariable("id") int id
		) {
		SingleRsp res = new SingleRsp();
		
		// Convert data
		RoomHistory m = new RoomHistory();
		m.setId(id);

		try {
			// Handle
			String tmp = roomHistoryService.checkOut(m);

			if (tmp.isEmpty()) {
				// Set Data
				res.setResult(tmp);
				res.setMessage("Add success!");
			} else {
				res.setError(tmp);
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/c/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCheckIn(
			@RequestHeader HttpHeaders header, 
			@PathVariable("id") int id) 
	{
		SingleRsp res = new SingleRsp();
		
		PayDto pay = null;
		
		try {
			pay = roomHistoryService.getPay(id);	 
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		} 
		
		if (pay != null) {
			// Set Data			
			res.setResult(pay);
		} else {
			res.setError("Can't check-in!");
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/check-in")
	public ResponseEntity<?> bookRoom(@RequestBody RoomHistoryReq req) {
		SingleRsp res = new SingleRsp();
		
		// Get data
		String typeId = req.getTypeId();
		int roomId = req.getRoomId();
		Date inDate = req.getInDate();
		String description = req.getDescription();
		
		//Convert date
		//DateFormat readFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss aa");
		//DateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		//Date inDateConverted = null;
		
//		try {
//			inDateConverted = readFormat.parse(inDate);
//		} catch (ParseException e) {
//		    e.printStackTrace();
//		}

		// Convert data
		RoomHistory m = new RoomHistory();
		m.setTypeId(typeId);
		m.setRoomId(roomId);
		m.setDescription(description);
		m.setInDate(inDate);

		try {
			// Handle
			String tmp = roomHistoryService.save(m);

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
			String tmp = roomHistoryService.delete(id);

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