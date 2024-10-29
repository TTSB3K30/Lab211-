/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

/**
 *
 * @author admin
 */
public class Student {
    String ID, StudentName, Semester, CourseName;

    public Student() {
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
    
}
