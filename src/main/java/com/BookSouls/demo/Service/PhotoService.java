package com.BookSouls.demo.Service;



import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.BookSouls.Entity.Photo;
import com.BookSouls.demo.DAO.PhotoRepository;
import com.BookSouls.demo.DAO.PhotoRepositoryCustom;

@Service
public class PhotoService {
	@Autowired
    private PhotoRepository photoRepo;
	@Autowired
	private PhotoRepositoryCustom photoRepositoryCustom;
	
	public String addPhoto(MultipartFile file){
		int id = photoRepositoryCustom.getMaxPhotoId() + 1;
		try {
	        Photo photo = new Photo(id, null);
	        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
	        photo = photoRepo.insert(photo); 
	        return null;
		}catch(Exception e) {
			return null;
		}
	}

    public Photo getPhoto(int id) {
        return photoRepo.findById(id).get();
    }
}
