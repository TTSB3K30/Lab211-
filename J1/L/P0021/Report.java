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
public class Report {
    String StudentName, CourseName;
    int Totalcourse;

    public Report() {
    }

    public Report(String StudentName, String CourseName, int Totalcourse) {
        this.StudentName = StudentName;
        this.CourseName = CourseName;
        this.Totalcourse = Totalcourse;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
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
    
    
}
