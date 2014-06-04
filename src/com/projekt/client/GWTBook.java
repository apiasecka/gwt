package com.projekt.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.projekt.shared.models.Books;

public class GWTBook implements EntryPoint {

	private final BookServiceAsync bookService = GWT.create(BookService.class);
	
	@Override
	public void onModuleLoad() {
		final TextBox myBook = new TextBox();
		Button createNewButton = new Button("Dodaj");
		Label label = new Label("Podaj tytuł: ");
		
		RootPanel.get("createNew").add(label);
		RootPanel.get("createNew").add(myBook);
		RootPanel.get("createNew").add(createNewButton);
		createNewButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				addBook(myBook.getValue());
				
			}});
		
		getAllBook();
		
		
	}

	void getAllBook(){
		bookService.showAllBook(new AsyncCallback<List<Books>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<Books> result) {
				
				
				DOM.getElementById("contentTable").setInnerHTML("");
				Element table = DOM.createTable(); 
				DOM.getElementById("contentTable").appendChild(table);
//				table.appendChild(null);
				
				for (Books m:result){
					final Long cos = m.getId();
					Button deleteButton = new Button("Usun");
					deleteButton.addClickHandler(new ClickHandler(){

						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
//							deleteMovie(m.getId());
							deleteBook(cos);
						}
						
					});
					
					Element td1 = DOM.createTD();
					td1.setInnerText(m.getbookTitle());
					
					Element td5 = DOM.createTD();
					td5.setAttribute("id","book" + String.valueOf(m.getId()));

					
					Element tr = DOM.createTR();
					
					tr.appendChild(td1);
					tr.appendChild(td5);
					table.appendChild(tr);
					
					RootPanel.get("book" + String.valueOf(m.getId())).add(deleteButton);
				
				}
				
				
			}
			
		});
	}
	
	void addBook(String title){
		Books book = new Books(title);
		bookService.addBook(book, new AsyncCallback<Boolean>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				getAllBook();
			}
			
		});
	}
	
	void deleteBook(Long id){
		bookService.removeBook(id, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				getAllBook();
			}
			
		});
	}
	
}
