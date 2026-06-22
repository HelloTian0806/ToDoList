package com.tian.model;

public class Todo {
	private int id;
	private String title;
	private Boolean completed;
	
	public Todo(String title) {
		this.title = title;
		this.completed = false;
	}
	public void steId(int id) {
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getTitle() {
		return this.title;
	}
	
	public Boolean getCompleted() {
		return this.completed;
	}
}
