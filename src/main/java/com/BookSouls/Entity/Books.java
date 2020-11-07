package com.BookSouls.Entity;




import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class Books {
	@Id
	long id;
	String name;
	String authorName;
	String description;
	String category;
	int isbNumber;
	int price;
	String usage;
	List<String> image;
	String sellerId; //user id
	
	public Books (long id, String name, String authorName, String description,String category, int isbNumber, int price, String usage, List<String> image, String sellerId) {
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.description = description;
		this.category = category;
		this.isbNumber = isbNumber;
		this.price = price;
		this.usage = usage;
		this.image = image;
		this.sellerId = sellerId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsbNumber() {
		return isbNumber;
	}

	public void setIsbNumber(int isbNumber) {
		this.isbNumber = isbNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", authorName=" + authorName + ", description=" + description
				+ ", category=" + category + ", isbNumber=" + isbNumber + ", price=" + price + ", usage=" + usage
				+ ", image=" + image + ", sellerId=" + sellerId + "]";
	}

	
}
