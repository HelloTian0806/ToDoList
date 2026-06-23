package com.tian.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.tian.model.Todo;

public class TodoService {
	private ArrayList<Todo> todolist = new ArrayList<Todo>();
	private int maxId=0;
	public void addTodo(String content) {
		int id = getMaxId();
		Todo todo = new Todo(id,content, false);
		todolist.add(todo);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("ToDoList.txt", true)))
		{
			bw.write(todo.getId()+","+todo.getContent()+","+todo.getCompleted());
			bw.newLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("新增一筆資料成功!");
	}
	public void showTodo() {
		for(Todo todo : todolist) {
			System.out.print(todo.getId()+",");
			System.out.print(todo.getContent()+",");
			System.out.print(covertCompleted(todo.getCompleted()));
			System.out.println();

		}
	}
	public void deleteTodo() {
		
	}
	
	public void completeTodo() {
		
	}
	private String covertCompleted(boolean complete) {
		if(complete == false) {
			return "未完成";
		}else {
			return "完成";
		}
	}
	
	public void loadTodoList() {
		File file = new File("ToDoList.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("新檔案建立成功");
			}else {
				try(BufferedReader br = new BufferedReader(new FileReader(file))){
					String line;
					while((line = br.readLine()) != null) {
						String[] part = line.split(",");
						int id = Integer.parseInt(part[0]);
						String content = part[1];
						boolean completed = Boolean.parseBoolean(part[2]);
						
						Todo todo = new Todo(id, content, completed);
						
						this.todolist.add(todo);
					}
				} catch(IOException e) {
						e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkInput(String input) {
		switch (input) {
		case "1":
			return true;
		case "2":
			return true;
		case "3":
			return true;
		case "4":
			return true;
		case "5":
			return true;
		default:
			System.out.println("輸入的功能無效!請重新輸入");
			return false;
		}
		
	}
	
	int getMaxId() {
		for(Todo todo : todolist) {
			if(todo.getId() >= maxId) {
				this.maxId= todo.getId();
			}
		}
		return maxId+1;
	}
}
