package com.cxy.javaweb.entity;


import java.util.List;

public class BooksBean {
	
	private String total;
	private List<BookInfo> rows;

	public void setRows(List<BookInfo> books) {
		this.rows = books;
	}

	public List<BookInfo> getRows() {
		return rows;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
