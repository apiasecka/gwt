package com.projekt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.projekt.shared.models.Books;

@RemoteServiceRelativePath("book")
public interface BookService extends RemoteService {
	public Boolean addBook(Books movie);
	public void removeBook(Long id);
	public void editBook(Books editedBook);
	public List<Books> showAllBook();
}
