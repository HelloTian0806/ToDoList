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
		// 注意scn.next()會跳過空白以及tab等等讀取下一段文字
		// 可是在下面有一個scn.nextLine()，他會把我再輸入完工能編號時把enter讀取進去
		// 所以必須在前面讀取完工能編號之後，用scn.nextLine()把剩下的enter讀取完
		todoService.loadTodoList();
		boolean ok = true;
		while(ok) {			
			String input = scn.next();
			scn.nextLine();
			switch(input) {
			case "1":
				todoService.showTodo();
				break;
			case "2":
				System.out.println("請輸入代辦事項");
				String todoText = scn.nextLine();
				todoService.addTodo(todoText);
				break;
			case "3":
				System.out.println("請選擇想要更改的編號:");
				int choiceM = scn.nextInt();
				scn.nextLine();
				System.out.println("請輸入想要更改的內容:");
				String contentM = scn.nextLine();
				if(todoService.modifyTodo(choiceM, contentM)) {
					System.out.println("修改成功!");
				} else {
					System.out.println("修改失敗!請確認編號正確無誤");
				}
				break;
			case "4":
				System.out.println("請輸入想刪除的編號:");
				int choiceD = scn.nextInt();
				if(todoService.deleteTodo(choiceD)) {
					System.out.println("成功刪除編號:"+choiceD);
				} else {
					System.out.println("找不到編號");
				}
				break;
			case "5":
				System.out.println("請輸入想要完成的事項編號");
				int choiceC = scn.nextInt();
				if(todoService.completeTodo(choiceC)) {
					System.out.println("成功更改");
				}else {
					System.out.println("更改失敗，請確認編號是否正確");
				}
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

