package com.projekt.shared.models;

import java.io.Serializable;

public class Books implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String bookTitle;

	public Books(){}
	
	public Books(String bookTitle){
		this.bookTitle = bookTitle;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getbookTitle() {
		return bookTitle;
	}

	public void setbookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
}
