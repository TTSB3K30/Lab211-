/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerStudent;

import ManagerStudent.Report;
import ManagerStudent.Student;
import ManagerStudent.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author admin
 */
public class Manager {
    private ArrayList<Student> list;

    public Manager() {
    }

    public Manager(ArrayList<Student> s) {
        this.list = s;
    }
    
    
    int count = 0;
    
    //Hàm thêm học sinh vào trong danh sách
    void add(){
        do {            
            String ID = Validation.InputString("Enter ID: ");
            String StudentName = Validation.InputString("Enter Name: ");
            if (!Validation.checkID(list, ID, StudentName)) {
                System.out.println("ID has exit, Please enter again: ");
                continue;
            }
            String Semester = Validation.InputString(" Enter Semester: ");
            System.out.println("Enter Course: ");
            String CourseName = Validation.checkCourseName();
            Student s = new Student(ID, StudentName, Semester, CourseName);
            if (!Validation.checkStudentExit(list, ID, StudentName, Semester, CourseName)) {
                System.out.println("Duplicate!!! Please enter again!!!");
                continue;
            }
            list.add(s);
            count++;
            return;
        } while (true);
    }
    
    //Hàm kiểm tra số hs nhập vào nếu lớn hơn 10
    void Create(int size){
        try {
            for (int i = 0; i < size; i++) {
                if (count < 10) {
                    add();
                }
                if (count >= 10) {
                    System.out.println("Number of student greater than 10. Do you want to continue(Y/N): ");
                    if (!Validation.checkYN()) {
                        return;
                    } else {
                        add();
                        return;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    //Hàm tìm kiếm và sắp xếp
    void FindandSort(){
        //Check list empty
        if (list.isEmpty() || list == null) {
            System.err.println("List is Empty!!!");
            return;
        }
        String fName = Validation.InputString("Enter student name you want to find: ");
        boolean find = false;//Theo dõi xem có tìm thấy đc hs nào ko
        
        //Tạo ds mới để lưu hs nếu tìm thấy
        ArrayList<Student> st = new ArrayList<>();
        
        for (Student item : list) {//Duyệt qua danh sách hs
            if (item.getStudentName().contains(fName)) {
                //Contains kiêm tra 1 chuỗi có chứ chuỗi con ko
                //Kiểm tra tên hs có giống tên hs nhập vào ko
                find = true;
                st.add(item);//Nếu thấy thì thêm vào ds st
            }
        }
        if (!find) {
            System.err.println("Can't found student!!!");
        }
        
        //Sắp xếp
        Collections.sort(st, new Comparator<Student>(){
        //Sắp xếp danh sách sinh viên theo tên
        //Comparator để so sánh 2 đối tượng
            @Override//Ghi đè hướng đối tượng
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
                //Hàm so sánh tên 2 sinh viên nếu = 0 thì 2 hs bằng nhau nếu âm thì tên hs1 < tên hs2
            }
        });
        
        if (find) {//Nếu tìm thấy thì in ra
            System.out.printf("%-10s%-15s%-15s%-15s\n", "ID", "Student Name", "Semester", "Course Name");
            for (Student item2 : st) {
                System.out.printf("%-10s%-15s%-15s%-15s\n",item2.getID(),
                        item2.getStudentName(),
                        item2.getSemester(),
                        item2.getCourseName());
            }
        }
    }
    
    //cho phép người dùng tìm kiếm học sinh theo ID. 
    //Sau khi tìm thấy học sinh theo ID, một câu hỏi sẽ được hiển thị (Bạn có muốn cập nhật (U)
    //hoặc xóa (D) học sinh. Nếu người dùng chọn U, 
    //chương trình cho phép người dùng cập nhật. Chọn D để xóa học sinh.
    public void Update(String s){
        int j = 0;
        int a[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equalsIgnoreCase(s)) {
                a[j] = i;
                System.out.println((j++) + "|" + list.get(i).getStudentName() + "|" +
                        list.get(i).getSemester() + "|" + 
                        list.get(i).getCourseName());
            }
        }
        
        if (j == 0) { // Không tìm thấy sinh viên với ID
            System.err.println("Not found student with ID: " + s);
            return;
        }
        
        int n = -1;
        do {            
            n = Validation.InputInt("Enter no of data u want to U from 0 to " + (j - 1));
        } while (n < 0 || n >= j);
        
        do {            
            String ID = Validation.InputString("Enter new ID");
            Student st = new Student(list.get(a[n]));
            String newStudentName = Validation.InputString("Enter new student's name: ");
            if (!Validation.checkID(list, ID, newStudentName)) {
                System.out.println("ID has exit, please enter again: ");
                continue;
            }
            String Semes = Validation.InputString("Enter Semester: ");
            System.out.println("Enter new coursename: ");
            String CourseName = Validation.checkCourseName();
            if (!Validation.checkStudentExit(list, ID, newStudentName, Semes, CourseName)) {
                System.err.println("Duplicate!!! Please enter again!!!");
                continue;
            }
            
            st.setID(ID);
            st.setStudentName(newStudentName);
            st.setSemester(Semes);
            st.setCourseName(CourseName);
            list.remove(a[n]);
            list.add(st);
            System.out.println("Update Done");
            return;
        } while (true);
    }
    
    public void Delete(String s){
        int j = 0;
        int a[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equalsIgnoreCase(s)) {
                a[j] = i;
                System.out.println((j++) + "|" + list.get(i).getStudentName() + "|" +
                        list.get(i).getSemester() + "|" + 
                        list.get(i).getCourseName());
            }
        }
        int n = -1;
        do {            
            n = Validation.InputInt("Enter no of data u want to D from 0 to " + (j - 1));
        } while (n < 0 || n>= j);
        
        list.remove(a[n]);
        System.out.println("Delete Successfull!!!");
    }
    
    void UpdateAndDelete(){
        //Check list empty
        if (list.isEmpty() || list == null) {
            System.err.println("List is Empty!!!");
            return;
        }
        String findID = Validation.InputString("Enter student's ID you want to Update/Delete: ");
        boolean find = false;
        ArrayList<Student> findByID = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().contains(findID)) {
                find = true;
            }
        }
        
        if (find) {
            String option = Validation.InputString("Do you want to Update(u/U) or Delete(d/D)?");
            if (option.equalsIgnoreCase("U")) {
                Update(findID);
            } else if (option.equalsIgnoreCase("D")) {
                Delete(findID);
            }else{
                System.err.println("Invalid input!!!"); // Xử lý đầu vào không hợp lệ
            }
        } else {
            System.err.println("Not found student with ID: " + findID);
        }
    }
    
    void report(ArrayList<Student> list){
        if (list.isEmpty()) {
            System.err.println("List is Empty!!!");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int total;
        for (Student item1 : list) {
            total = 0;
            for (Student item2 : list) {
                if (item1.getID().equalsIgnoreCase(item2.getID()) && 
                        item1.getCourseName().equalsIgnoreCase(item2.getCourseName())) {
                    total++;
                }
            }
            if (Validation.checkReport(lr, item1.getStudentName(), item1.getCourseName(), total)) {
                lr.add(new Report(item1.getStudentName(), item1.getCourseName(), total));
            }
        }
        //In ra report
        for (Report rp : lr) {
            System.out.printf("%-15s|%-10s|%-5s\n", rp.getStudentName(), 
                    rp.getCourseName(), rp.getTotalcourse());
        }
    }
}
