package com.todo;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;
import java.util.Scanner;

public class ToDoMain {
    public static void start(){
        Scanner sc=new Scanner(System.in);
        TodoList l=new TodoList();
        boolean isList;
        boolean quit = false;

        Menu.displaymenu();

        do{
            Menu.prompt();
            isList=false;
            String choice=sc.next();
            switch (choice) {
                case "add" -> TodoUtil.createItem(l);
                case "del" -> TodoUtil.deleteItem(l);
                case "edit" -> TodoUtil.updateItem(l);
                case "ls" -> TodoUtil.listAll(l);
                case "ls_name_asc" -> {
                    l.sortByName();
                    System.out.println("제목순으로 정렬하였습니다");
                    isList = true;
                }
                case "ls_name_desc" -> {
                    l.sortByName();
                    l.reverseList();
                    System.out.println("제목역순으로 정렬하였습니다");
                    isList = true;
                }
                case "ls_date" -> {
                    l.sortByDate();
                    System.out.println("날짜순으로 정렬하였습니다");
                    isList = true;
                }
                case "help" -> Menu.displaymenu();
                case "exit" -> quit = true;
                default -> System.out.println("정확하 명령어를 입력하세요 (도움말 명령어는 help)");
            }
            if(isList) TodoUtil.listAll(l);
        }while (!quit);
    }
}
