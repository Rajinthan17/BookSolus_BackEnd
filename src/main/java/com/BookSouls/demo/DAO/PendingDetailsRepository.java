package com.BookSouls.demo.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.BookSouls.Entity.PendingDetails;

@Repository
public interface PendingDetailsRepository  extends MongoRepository<PendingDetails, Integer>{

	@Query("{$or: [ { 'bookName': { $regex: ?0 , $options: 'i' } }, { 'buyerName':{ $regex: ?0, $options: 'i' } },{ 'buyerAddress': { $regex: ?0 , $options: 'i' } },{ 'buyerPhoneNum': { $regex: ?0 , $options: 'i' } } ]}")
	List<PendingDetails> findBySearchContaining(String searched);

}
