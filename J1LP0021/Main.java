/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

/**
 *
 * @author admin
 */
public class Main {
    
     public static void menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
    }
    
    public static void main(String[] args) {
        Validation validation = new Validation();
        Student sm = new Student();
        while (true) {
            menu();
            System.out.print("> Your choice: ");
            int choice = validation.getIntInRange(1, 5);
            switch (choice) {
                case 1:
                    boolean check = false;
                    while (sm.studentList.size() < 3) {
                        Student student = new Student();
                        sm.createStudent();
                        sm.addStudent(student);
                        System.err.println("Added successfully!");
                        check = true;
                    }
                    if (sm.studentList.size() == 3 && check) {
                        System.out.print("Do you want to continue: ");
                        if (validation.getYN()) {
                            Student student1 = new Student();
                            student1.createStudent();
                            sm.addStudent(student1);
                            System.err.println("Added successfully!");
                            break;
                        } else {
                            break;
                        }
                    }
                    Student student = new Student();
                    student.createStudent();
                    sm.addStudent(student);
                    System.err.println("Added successfully!");
                    break;
                case 2:
                    if (sm.studentList.isEmpty()) {
                        System.err.println("List is empty!");
                        break;
                    }
                    System.out.print("Input name (or a part of name): ");
                    String str = validation.getString();
                    sm.findAndSort(str);
                    break;
                case 3:
                    if (sm.studentList.isEmpty()) {
                        System.err.println("List is empty!");
                        break;
                    }
                    System.out.print("Input id: ");
                    String id = validation.getString();
                    Student hs = sm.findStudentById(id);
                    if (hs != null) {
                        System.out.print("Do you want to update (U) or delete (D) student: ");
                        String in = validation.getUD();
                        switch (in) {
                            case "u":
                                Student newSV = new Student();
                                newSV.updateInfo(id);
                                sm.updateStudent(newSV);
                                break;
                            case "d":
                                sm.deleteStudent(hs);
                                break;
                            default:
                                System.err.println("Invalid");
                        }
                    } else {
                        System.err.println("Not found!");
                    }
                    break;
                case 4:
                    if (sm.studentList.isEmpty()) {
                        System.err.println("List is empty!");
                        break;
                    }
                    sm.report();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Invalid!");
            }
        }
    }
}