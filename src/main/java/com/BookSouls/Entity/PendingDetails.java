//Delivery Details back end
package com.BookSouls.Entity;

public class PendingDetails {
	
	
	private int id;
	private String bookName;
	private String buyerName;
	private String buyerAddress;
	private String buyerPhoneNum;
	
	public PendingDetails(int id, String bookName, String buyerName, String buyerAddress, String buyerPhoneNum ) {
		this.id = id;
		this.bookName = bookName;
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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	@Override
	public String toString() {
		return "PendingDetails [id=" + id + ", bookName=" + bookName + ", buyerName=" + buyerName + ", buyerAddress="
				+ buyerAddress + ", buyerPhoneNum=" + buyerPhoneNum + "]";
	}

	
	
}
