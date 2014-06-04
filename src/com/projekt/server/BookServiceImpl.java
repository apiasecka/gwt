package com.projekt.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.projekt.client.BookService;
import com.projekt.shared.models.Books;

public class BookServiceImpl extends RemoteServiceServlet implements BookService {

	private static final long serialVersionUID = 1L; 
	List<Books> db = new ArrayList<Books>();
	private Long counter = (long)1;
	
	@Override
	public Boolean addBook(Books book) {
		book.setId(counter++);
		return this.db.add(book);
	}

	@Override
	public void removeBook(Long id) {
		for (Books m : db){
			System.out.print(m.getId()+"\n"+ id);
			if(m.getId() == id){
				this.db.remove(m);
				break;
			}
		}
	}

	@Override
	public void editBook(Books editedBook) {
		int i = 0;
		for(Books m : db){
			if(m.getId() == editedBook.getId()){
				this.db.set(i, editedBook);
				break;
			}
			i++;
		}
	}

	@Override
	public List<Books> showAllBook() {
		return db;
	}

}
