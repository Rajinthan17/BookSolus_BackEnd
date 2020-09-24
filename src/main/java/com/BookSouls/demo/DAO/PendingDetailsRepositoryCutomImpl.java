package com.BookSouls.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.BookSouls.Entity.PendingDetails;



@Repository
public class PendingDetailsRepositoryCutomImpl implements PendingDetailsRepositoryCutom  {

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public int getMaxPendingDetailID() {
		Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "id"));
        query.limit(1);
        
        PendingDetails maxObject = mongoTemplate.findOne(query, PendingDetails.class);
        if (maxObject == null) {
            return 0;
        }
        return maxObject.getId();
	}

}
