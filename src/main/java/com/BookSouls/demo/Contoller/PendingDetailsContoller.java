package com.BookSouls.demo.Contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookSouls.Entity.PendingDetails;
import com.BookSouls.demo.Service.PendingDetailsService;

@CrossOrigin ("*")
@RestController
@RequestMapping(value = "/pending")
public class PendingDetailsContoller {
	
	@Autowired
	PendingDetailsService pendingService;
	
	@PostMapping
	public ResponseEntity<PendingDetails> createPending (@RequestBody PendingDetails pendingDetails){
		return pendingService.createPending(pendingDetails);
	}
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<PendingDetails> deletePending(@PathVariable int id){
		return pendingService.deletePending(id);
	}
	
	@GetMapping (value = "/page")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity <Map<String, Object>> getAllPendings(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return pendingService.getAllPendings(pageNo,pageSize);
	}
	
	@GetMapping(value = "/page/serachedPages")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Map<String,Object>> getSerchedPendings(
			@RequestParam(name = "serched",defaultValue = "null") String searched,
			@RequestParam(name = "pageNo",defaultValue = "1") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize
			){
		return pendingService.searchedBooks(searched,pageNo,pageSize);
	}
}
