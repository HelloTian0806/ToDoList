package com.tian.model;

public class Todo {
	private int id;
	private String content;
	private boolean completed;
	
	public Todo(int id ,String content, boolean completed) {
		this.id = id;
		this.content = content;
		this.completed = false;
	}
	public Todo(String content) {
		this.content = content;
		this.completed = false;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getContent() {
		return this.content;
	}
	
	public Boolean getCompleted() {
		return this.completed;
	}
}
