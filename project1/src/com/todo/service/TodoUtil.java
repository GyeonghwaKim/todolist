package com.todo.service;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TodoUtil {
    static int count;

    public static void createItem(TodoList l){
        String category,title,desc,due_date;
        Scanner sc=new Scanner(System.in);

        System.out.print("[항목 추가]\n"+"카테고리 >");
        category=sc.nextLine().trim();

        System.out.print("제목 >");
        title=sc.nextLine().trim();
        //중복 검사
        if(l.isDuplicate(title)){
            System.out.println("중복된 제목입니다");
            return;
        }
        System.out.print("내용 >");
        //혹시라도 있을 좌우 여백 제거 trim();
        desc=sc.nextLine();
        System.out.print("마감기한 >");
        //혹시라도 있을 좌우 여백 제거 trim();
        due_date=sc.nextLine();
        TodoItem t=new TodoItem(category,title,desc,due_date);
        l.addItem(t);
        System.out.println("추가되었습니다");

    }

    public static void deleteItem(TodoList l){
        Scanner sc=new Scanner(System.in);
        System.out.println("[항목 삭제]\n"+"삭제할 항목의 번호를 입력하시오 >");
        int num=sc.nextInt();

        for(TodoItem item:l.getList()){
            if(--num==0){
                System.out.println(item.toString());
                System.out.println("위 항목을 삭제하시겠습니까 (y/n) >");
                String answer=sc.next().trim();
                if(answer.equals("y")){
                    l.deleteItem(item);
                    System.out.println("삭제되었습니다.");
                }
                break;
            }
            }
        }

    public static void updateItem(TodoList l) {
        Scanner sc=new Scanner(System.in);

        System.out.print("[항목 수정]\n"+"수정할 항목의 항목을 입력하시오>");
        int num=Integer.parseInt(sc.nextLine().trim());
        int cnt=0;
        for(TodoItem item:l.getList()){
            if(++cnt==num){
                System.out.println(item.toString());
                l.deleteItem(item);
            }
        }

        System.out.print("새 제목 > ");
        String new_title=sc.nextLine().trim();

        if(l.isDuplicate(new_title)){
            System.out.println("제목이 중복됩니다!");
            return;
        }

        System.out.print("새 카테고리 >");
        String new_category=sc.nextLine().trim();

        System.out.print("새 내용 > ");
        String new_description=sc.nextLine().trim();
        System.out.print("새 마감기한 > ");
        String new_due_date=sc.nextLine().trim();
        //여기로 돌려놓기

        TodoItem t=new TodoItem(new_category,new_title,new_description,new_due_date);
        l.addItem(t);
        System.out.println("수정되었습니다.");
    }
    public static void listAll(TodoList l){
        System.out.println("[전체 목록, 총 "+l.length()+"개]");
        int num=0;
        for(TodoItem item:l.getList()){
            System.out.println(++num+". "+item.toString());

        }
    }
    //프로그램  시작시 읽기, 종료시 저장 메소드 구현 - 2강
    //만든 todolist를 txt로 저장
    public static void saveList(TodoList l,String filename){
        try {
            Writer w=new FileWriter(filename);
            for(TodoItem item:l.getList()){
                w.write(item.toSaveString());
            }
            w.close();
            System.out.println("모든 데이터가 저장되었습니다");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void loadList(TodoList l,String filename){
        try {
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String line;
            count=0;
            while((line=br.readLine())!=null){
                StringTokenizer st=new StringTokenizer(line,"##");
                String categroy= st.nextToken();
                String title=st.nextToken();
                String description=st.nextToken();
                String due_date= st.nextToken();
                String current_date=st.nextToken();
                TodoItem item=new TodoItem(categroy,title,description,due_date);
                item.setCurrent_date(current_date);
                l.addItem(item);
                count++;
            }
            br.close();
            System.out.println(count+"개의 항목을 읽었습니다");
        }catch (FileNotFoundException e){
            System.out.println(filename+"파일이 없습니다.");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void findItem(String str,TodoList l){
        int cnt=0;
        for(TodoItem item:l.getList()){
            if(item.contains(str)){
                System.out.println(item.toString());
                cnt++;
            }
        }
        System.out.println("총 "+cnt+"개의 항목을 찾았습니다");

    }
}
