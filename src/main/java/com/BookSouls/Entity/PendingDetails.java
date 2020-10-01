//Delivery Details back end
package com.BookSouls.Entity;

public class PendingDetails {
	
	
	private int id;
	private Books book;
	private String buyerName;
	private String buyerAddress;
	private String buyerPhoneNum;
	
	public PendingDetails(int id,Books book, String buyerName, String buyerAddress, String buyerPhoneNum ) {
		this.id = id;
		this.book = book;
		this.buyerName = buyerName;
		this.buyerAddress = buyerAddress;
		this.buyerPhoneNum = buyerPhoneNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerPhoneNum() {
		return buyerPhoneNum;
	}

	public void setBuyerPhoneNum(String buyerPhoneNum) {
		this.buyerPhoneNum = buyerPhoneNum;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "PendingDetails [id=" + id + ", book=" + book + ", buyerName=" + buyerName + ", buyerAddress="
				+ buyerAddress + ", buyerPhoneNum=" + buyerPhoneNum + "]";
	}

	
}
