package com.projekt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.projekt.shared.models.Books;

public interface BookServiceAsync {
	void addBook(Books book, AsyncCallback<Boolean> callback);
	void removeBook(Long id, AsyncCallback<Void> callback);
	void editBook(Books editedBook, AsyncCallback<Void> callback);
	void showAllBook(AsyncCallback<List<Books>> callback);
}
