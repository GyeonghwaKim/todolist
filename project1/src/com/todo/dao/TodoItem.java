package com.todo.dao;

import java.util.Date;
import java.util.Objects;

public class TodoItem {


    //할일 입력
    private String title; //제목
    private String desc;//내용
    private Date current_date; //입력 날짜

    public TodoItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
        //작성되는 현재시간을 그대로 들고와서 new date();
        this.current_date = new Date();
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public Date getCurrent_date() {
        return current_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }

    @Override
    public String toString() {
        return "[" +title+ "]" + desc + "-"  + current_date;
    }



}

