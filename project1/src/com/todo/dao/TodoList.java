package com.todo.dao;

import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    private List<TodoItem> list;

    public TodoList() {
        this.list = new ArrayList<TodoItem>();
    }


    public void addItem(TodoItem t){
        list.add(t);
    }

    public void deleteItem(TodoItem t){
        list.remove(t);
    }

    public void editItem(TodoItem t,TodoItem updated){
        int index=list.indexOf(t);
        list.remove(index); //?
        list.add(updated);
    }

    public ArrayList<TodoItem> getList(){
        return new ArrayList<TodoItem>(list);
    }


    public void sortByName(){
        Collections.sort(list,new TodoSortByName());

    }

    public void reverseList(){
        Collections.reverse(list);

    }

    public void sortByDate(){
        Collections.sort(list,new TodoSortByDate());

    }

    public int indexOf(TodoItem t){
        return list.indexOf(t);
    }

    //비교해서 있는가없는가
    public Boolean isDuplicate(String title){
        for(TodoItem item:list){
            if(title.equals(item.getTitle())) return true;
        }
        return false;
    }

    public int length(){
        return list.size();
    }

//    public static void listAll(TodoList l){
//
//    }

}
