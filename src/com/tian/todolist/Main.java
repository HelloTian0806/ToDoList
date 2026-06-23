package com.tian.todolist;


import java.util.Scanner;

import com.tian.service.TodoService;

public class Main {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("歡迎使用to do list");
		System.out.println("請輸入想要使用的功能:");
		System.out.println("1.查詢所有List");
		System.out.println("2.新增");
		System.out.println("3.修改");
		System.out.println("4.刪除");
		System.out.println("5.標記完成");
		System.out.println("離開請輸入exit");
		
		TodoService todoService = new TodoService();
		
		todoService.loadTodoList();
		boolean ok = true;
		while(ok) {			
			String input = scn.next();
			
			switch(input) {
			case "1":
				todoService.showTodo();
				break;
			case "2":
				System.out.println("請輸入代辦事項");
				String todoText = scn.next();
				todoService.addTodo(todoText);
				break;
			case "exit":
				ok = false;
				scn.close();
				break;
			default:
				System.out.println("輸入的功能無效!請重新輸入");
				break;
			}
		}
		
		
		
		}
		
	}

