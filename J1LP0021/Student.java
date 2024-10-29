/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author admin
 */
public class Student {
    private String ID, StudentName, Semester, CourseName;

    public Student() {
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

    @Override
    public String toString() {
        return StudentName + "-" + Semester + "-" + CourseName; //To change body of generated methods, choose Tools | Templates.
    }
    private Validation va = new Validation();
    
    public Student createStudent() {
        System.out.print("Input id: ");
        this.ID = va.getString();
        System.out.print("Input name: ");
        this.StudentName = va.getValidName(this.ID);
        System.out.print("Input semester: ");
        this.Semester = va.getString();
        System.out.print("Input course name: ");
        this.CourseName = va.getCourse();
        return this;
    }

    public Student updateInfo(String id) {
        this.ID = id;
        System.out.print("Input name: ");
        this.StudentName= va.getValidName(this.ID);
        System.out.print("Input semester: ");
        this.Semester = va.getString();
        System.out.print("Input course name: ");
        this.CourseName = va.getCourse();
        return this;
    }
    
    ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void findAndSort(String str) {
        Student result = findStudentByName(str);
        if (!result.studentList.isEmpty()) {
            result.sort();
            result.studentList.forEach((x) -> {
                System.out.println(x.toString());
            });
        } else {
            System.err.println("Not found!");
        }
    }

    public void sort() {
        Collections.sort(studentList, (Student o1, Student o2) -> {
            // So sánh ID theo thứ tự số bằng compareToIgnoreCase
            //Trả về giá trị âm nếu o1 < o2.
            //Trả về giá trị dương nếu o1 > o2.
            //Trả về 0 nếu hai chuỗi bằng nhau.
            return o1.getID().compareToIgnoreCase(o2.getID());
        });
    }

    public void updateStudent(Student student) {
        for (Student x : studentList) {
            if (x.getID() == student.getID()) {
                x.setStudentName(student.getStudentName());
                x.setSemester(student.getSemester());
                x.setCourseName(student.getCourseName());
            }
        }
        System.err.println("Updated successfully!");
    }

    public void deleteStudent(Student student) {
        studentList.remove(student);
        System.err.println("Deleted successfully!");
    }

    public void report() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student x : studentList) {
            String key = x.getID() + "#" + x.getStudentName() + "|" + x.getCourseName();
            if (reports.containsKey(key)) {
                int total = reports.get(key);
                reports.put(key, total + 1);
            } else {
                reports.put(key, 1);
            }
        }
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1] + "|" + reports.get(key));
        }
    }

    private Student findStudentByName(String str) {
        Student result = new Student();
        for (Student x : studentList) {
            if (x.getStudentName().contains(str)) {
                result.addStudent(x);
            }
        }
        return result;
    }


    public Student findStudentById(String id) {
        for (Student x : studentList) {
            if (x.getID().equalsIgnoreCase(id)) {
                return x;
            }
        }
        return null;
    }

    private boolean isExistID(String id) {
        for (Student x : studentList) {
            if (x.getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    
}
