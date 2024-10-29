/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0021;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {            
            System.out.println("1. Create\n"
                     + "2. Find anh Sort\n"
                     + "3. Update and Delete\n"
                     + "4. Report\n"
                     + "5. Exit");
            int choice = Validation.InputInt("Enter your choice: ");
            Manager m = new Manager(list);
            switch(choice){
                case 1:{
                    int size = Validation.checkSize();
                    m.Create(size);
                    break;
                }
                case 2:{
                    m.FindandSort();
                    break;
                }
                case 3:{
                    m.UpdateAndDelete();
                    break;
                }
                case 4:{
                    m.report(list);
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
    }
}
