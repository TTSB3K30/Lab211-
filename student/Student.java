/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author admin
 */
public class Student {

    String ID, StudentName, Semester, CourseName;
    int Totalcourse;

    public Student() {
    }
    
    public Student(ArrayList<Student> list) {
        this.list = list;
    }
    
    public Student(String StudentName, String CourseName, int Totalcourse) {
        this.StudentName = StudentName;
        this.CourseName = CourseName;
        this.Totalcourse = Totalcourse;
    }

    public Student(Student x) {
        this.ID = x.ID;
        this.StudentName = x.StudentName;
        this.Semester = x.Semester;
        this.CourseName = x.CourseName;
    }
    
    public Student(String ID, String StudentName, String Semester, String CourseName) {
        this.ID = ID;
        this.StudentName = StudentName;
        this.Semester = Semester;
        this.CourseName = CourseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getTotalcourse() {
        return Totalcourse;
    }

    public void setTotalcourse(int Totalcourse) {
        this.Totalcourse = Totalcourse;
    }
    
    
    
    private ArrayList<Student> list;
    
    int count = 0;
    
    //Hàm thêm học sinh vào trong danh sách
    void add(){
        try {
            do {            
                String ID = Validation.InputString("Enter ID: ");
                String StudentName = Validation.InputString("Enter Name: ");
                if (!Validation.checkID(list, ID, StudentName)) {//Kiểm tra xem ID có trùng với tên hay ko
                    System.out.println("ID has exit, Please enter again: ");
                    continue;
                }
                String Semester = Validation.InputString("Enter Semester: ");
                System.out.print("Enter Course: ");
                String CourseName = Validation.checkCourseName();
                Student s = new Student(ID, StudentName, Semester, CourseName);
                if (!Validation.checkStudentExit(list, ID, StudentName, Semester, CourseName)) {//Kiểm tra xem hs này đã tồn tại hay chưa
                    System.out.println("Duplicate!!! Please enter again!!!");
                    continue;
                }
                list.add(s);//thêm vào trong list hs
                count++;//đếm xem đã nhập đc bn hs
                return;
            } while (true);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
    
    //Hàm kiểm tra số hs nhập vào nếu lớn hơn 10 thì hỏi có muốn tiếp tục hay không
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
            System.out.println("" + e.getMessage());
        }
    }
    
    //Hàm tìm kiếm và sắp xếp
    void FindandSort(){
        try {
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
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
    
    //cho phép người dùng tìm kiếm học sinh theo ID. 
    //Sau khi tìm thấy học sinh theo ID, một câu hỏi sẽ được hiển thị (Bạn có muốn cập nhật (U)
    //hoặc xóa (D) học sinh. Nếu người dùng chọn U, 
    //chương trình cho phép người dùng cập nhật. Chọn D để xóa học sinh.
    public void Update(String s){
        try {
            int j = 0;//Lưu trự biến đếm số lượng sv tìm thấy vs ID trùng
            int a[] = new int[list.size()];//Tạo mảng với kích thước list.size lưu trữ chỉ số của các sv có ID trùng
            for (int i = 0; i < list.size(); i++) {//Duyệt qua ds list để tìm kiếm sv có ID trùng với s
                if (list.get(i).getID().equalsIgnoreCase(s)) {
                    a[j] = i;
                    System.out.println((j++) + " | " + list.get(i).getStudentName() + " | " +
                            list.get(i).getSemester() + " | " + 
                            list.get(i).getCourseName());
                }
            }
            System.out.println("");

            if (j == 0) { // Không tìm thấy sinh viên với ID
                System.err.println("Not found student with ID: " + s);
                return;
            }

            int n = -1;
            do {            
                n = Validation.InputInt("Enter no of data you want to U from 0 to " + (j - 1));
            } while (n < 0 || n >= j);

            do {//Lặp lại cho đến khi nhập thông tin hợp lệ  
                Student st = new Student(list.get(a[n]));// Tạo đối tượng student mới sao chép từ sv đc chọn(có chỉ số a[n] trong d/s list 
                String newSemes = Validation.InputString("Enter Semester: ");
                System.out.print("Enter new coursename: ");
                String newCourseName = Validation.checkCourseName();
                if (!Validation.checkStudentExit(list, st.getID(), st.getStudentName(), newSemes, newCourseName)) {
                    System.err.println("Duplicate!!! Please enter again!!!");
                    continue;
                }
                st.setSemester(newSemes);
                st.setCourseName(newCourseName);
                list.remove(a[n]);
                list.add(st);
                System.err.println("Update Done!!!");
                return;
            } while (true);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
    
    public void Delete(String s){
        try {
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
                n = Validation.InputInt("Enter no of data you want to D from 0 to " + (j - 1));
            } while (n < 0 || n>= j);

            list.remove(a[n]);
            System.err.println("Delete Successfull!!!");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
    
    void UpdateAndDelete(){
        try {
            //Check list empty
            if (list.isEmpty() || list == null) {
                System.err.println("List is Empty!!!");
                return;
            }
            System.out.printf("%-10s%-15s%-15s%-15s\n", "ID", "Student Name", "Semester", "Course Name");
                for (Student st : list) {
                    System.out.printf("%-10s%-15s%-15s%-15s\n",st.getID(),
                            st.getStudentName(),
                            st.getSemester(),
                            st.getCourseName());
                }
                
            System.out.println("");
            //In ra tất cả các sv có trong list
            
            String findID = Validation.InputString("Enter student's ID you want to Update/Delete: ");//Nhập ID sv muốn thay đổi
            boolean find = false;
//            ArrayList<Student> findByID = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getID().contains(findID)) {
                    find = true;
                }
            }

            if (find) {
                String option = Validation.InputString("Do you want to Update(u/U) or Delete(d/D)?");
                if (option.equalsIgnoreCase("U")) {
                    System.out.println("==========================================");
                    Update(findID);
                } else if (option.equalsIgnoreCase("D")) {
                    System.out.println("==========================================");
                    Delete(findID);
                }else{
                    System.err.println("Invalid input!!!"); // Xử lý đầu vào không hợp lệ
                }
            } else {
                System.err.println("Not found student with ID: " + findID);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
    
    //Kiểm tra report
    public static boolean checkReport(ArrayList<Student> lr, String name, String course, int total) {
        for (Student report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalcourse()) {
                return false;
            }
        }
        return true;
    }

    void report(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.err.println("List is Empty!!!");
            return;
        }
        ArrayList<Student> lr = new ArrayList<>();
        int total;
        for (Student item1 : list) {
            total = 0;
            for (Student item2 : list) {
                if (item1.getID().equalsIgnoreCase(item2.getID())
                        && item1.getCourseName().equalsIgnoreCase(item2.getCourseName())) {
                    total++;
                }
            }
            if (checkReport(lr, item1.getStudentName(), item1.getCourseName(), total)) {
                lr.add(new Student(item1.getStudentName(), item1.getCourseName(), total));
            }
        }
        //In ra report
        System.out.println("The report as below: ");
        for (Student rp : lr) {
            System.out.printf("%-15s| %-10s| %-5s\n", rp.getStudentName(),
                    rp.getCourseName(), rp.getTotalcourse());
        }
    }
    
}
