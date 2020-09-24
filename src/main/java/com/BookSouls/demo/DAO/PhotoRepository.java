package com.BookSouls.demo.DAO;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BookSouls.Entity.Photo;


@Repository
public interface PhotoRepository extends MongoRepository<Photo, Integer> { 
	
}
