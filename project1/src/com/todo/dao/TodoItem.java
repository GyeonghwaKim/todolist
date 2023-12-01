package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TodoItem {


    //할일 입력
    private String title; //제목
    private String desc;//내용

    //편의성을 위해 문자열로 보관하는 것이 좋아서 수정 -2강
    private String current_date; //입력 날짜

    private String category;
    private String due_date;

    public TodoItem(String category,String title, String desc,String due_date) {
        this.category=category;
        this.title = title;
        this.desc = desc;
        this.due_date=due_date;
        SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date = f.format(new Date());


    }

    public String getCategory() {
        return category;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return  "[" +category+ "] "+title+ " - "  + desc + " - "  +due_date+" - "+ current_date;
    }


    //파일로 저장을 위한 메소드 추가 -2강
    public String toSaveString(){
        return category+"##"+title+"##"+desc+"##"+due_date+"##"+current_date+"\n";
    }

    public boolean contains(String str){{
        if(title.contains(str)||desc.contains(str)) return true;
        return false;
    }

    }

}

