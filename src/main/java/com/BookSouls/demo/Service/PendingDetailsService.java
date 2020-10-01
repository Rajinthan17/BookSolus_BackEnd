package com.BookSouls.demo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.BookSouls.Entity.PendingDetails;
import com.BookSouls.demo.DAO.PendingDetailsRepository;
import com.BookSouls.demo.DAO.PendingDetailsRepositoryCutom;

@Service
public class PendingDetailsService {

	@Autowired
	PendingDetailsRepository pendingRepo;
	
	@Autowired
	PendingDetailsRepositoryCutom pendingRepoCustom;

	public ResponseEntity<PendingDetails> createPending(PendingDetails pendingDetails) {
		try {
			int id = pendingRepoCustom.getMaxPendingDetailID()+1;
			PendingDetails newPending = pendingRepo.save(new PendingDetails(id,pendingDetails.getBook(),pendingDetails.getBuyerName(),pendingDetails.getBuyerAddress(),pendingDetails.getBuyerPhoneNum()));
			
			return new ResponseEntity<>(newPending,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	public ResponseEntity<PendingDetails> deletePending(int id) {
		try {
			Optional<PendingDetails> pendingData = pendingRepo.findById(id);
			if(pendingData.isPresent()) {
				pendingRepo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	public ResponseEntity<Map<String, Object>> getAllPendings(int pageNo, int pageSize) {
		try {
            Map<String, Object> response = new HashMap<>();
            Sort sort = Sort.by("id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<PendingDetails> page = pendingRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current page no", page.getNumber());
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<Map<String, Object>> searchedBooks(String searched, int pageNo, int pageSize) {

		List<PendingDetails> searchedBooks = pendingRepo.findBySearchContaining(searched);
		Map<String, Object> response = new HashMap<>();
		PagedListHolder<PendingDetails> page = new PagedListHolder<PendingDetails>(searchedBooks);
		page.setPageSize(pageSize); // number of items per page
		page.setPage(pageNo); 
		
		response.put("data", page.getPageList());
		response.put("Total_No_Of_Elements", page.getNrOfElements());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
