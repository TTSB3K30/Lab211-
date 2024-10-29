/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        try { 
            ArrayList<Student> list = new ArrayList<>();
                while (true) {            
                    System.out.println("===================WELCOME TO STUDENT MANAGEMENT==================\n"
                             + "1. Create\n"
                             + "2. Find anh Sort\n"
                             + "3. Update and Delete\n"
                             + "4. Report\n"
                             + "5. Exit");
                    int choice = Validation.InputInt("Enter your choice: ");
                    Student st = new Student(list);
                    Student rp = new Student();
                    switch(choice){
                        case 1:{
                            int size = Validation.checkSize();
                            st.Create(size);
                            break;
                        }
                        case 2:{
                            st.FindandSort();
                            break;
                        }
                        case 3:{
                            st.UpdateAndDelete();
                            break;
                        }
                        case 4:{
                            rp.report(list);
                            break;
                        }
                        case 5:{
                            System.exit(0);
                        }
                        default:{
                            System.err.printf("Select function from 1 to 5!!!!");
                        }
                    }
                }
        } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }
        }
    }

