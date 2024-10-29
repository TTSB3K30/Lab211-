/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    //Tạo một đối tượng BufferedReader mới, 
    //Tạo một đối tượng InputStreamReader để đọc dữ liệu từ luồng đầu vào làm nguồn dữ liệu. 
    //BufferedReader là một class giúp cho việc đọc dữ liệu từ luồng đầu vào hiệu quả hơn.
    
    //Kiểm tra nhập vào dạng int
    public static int InputInt(String mess){
        int n;
        do {            
            try {
                System.out.println(mess);
                n = Integer.parseInt(input.readLine());
                break;
            } catch (Exception e) {
                System.err.println("Please enter integer number!!!");
            }
        } while (true);
        return n;
    }
    
    //Kiểm tra nhập vào dạng Double
    public static double InputDouble(String mess){
        double n;
        do {            
            try {
                System.out.println(mess);
                n = Double.parseDouble(input.readLine());
                break;
            } catch (Exception e) {
                System.err.println("Please enter double number!!!");
            }
        } while (true);
        return n;
    }
    
    //Kiểm tra nhập vào dạng chuỗi -- Không trống không khoảng cách
    public static String InputString(String mess){
        String str = "";
        do {            
            try {
                System.out.println(mess);
                str = input.readLine().trim();
                if (str.length() == 0) {
                    System.err.println("Enter Again!!!");
                } else {
                    break;
                }
            } catch (Exception e) {
            }
        } while (true);
        return str;
    }
    
    //Kiểm tra yes/no
    public static boolean checkYN(){
        while (true) {            
            String result = InputString("");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }
    
    //Kiểm tra kích thước
    public static int checkSize(){
        int size;
        do {            
            try {
                size = InputInt("Enter size: ");
                if (size <= 0) {
                    System.err.println("Size must be > 0!!! Please enter again!!!");
                } else {
                    break;
                }
            } catch (Exception e) {
            }
        } while (true);
        return size;
    }
    
    //Kiểm tra các môn học
    public  static String checkCourseName(){
        while (true) {            
            String result = InputString("");
            if (result.equalsIgnoreCase("Java") || result.equalsIgnoreCase(".Net")
                    || result.equalsIgnoreCase("C/C++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.err.println("Enter Again!!!");
        }
    }
    
    //Kiểm tra ID
    public static boolean checkID(ArrayList<Student> list, String ID, String StudentName){
        for (Student student : list) {
            if (ID.equalsIgnoreCase(student.getID()) && 
                    !StudentName.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }
    
    //Kiểm tra xem student có tồn tại hay không
    public static boolean checkStudentExit(ArrayList<Student> list, String ID, 
            String StudentName, String Semester, String CourseName){
        for (Student student : list) {
            if (ID.equalsIgnoreCase(student.getID())
                && StudentName.equalsIgnoreCase(student.getStudentName())
                && Semester.equalsIgnoreCase(student.getSemester()) 
                && CourseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
    
    //Kiểm tra report
    public static boolean checkReport(ArrayList<Report> lr, String name, String course, int total){
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                && course.equalsIgnoreCase(report.getCourseName())
                && total == report.getTotalcourse()) {
                return false;
            }
        }
        return true;
    }
    
}
