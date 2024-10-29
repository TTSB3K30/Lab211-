/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0021;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {
    private Scanner scanner = new Scanner(System.in);
    private Student sm = new Student();

    public int getIntInRange(int min, int max) {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine());
                if (x >= min && x <= max) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer in [" + min + ", " + max + "]!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getString() {
        while (true) {
            try {
                String x = scanner.nextLine().trim();
                if (!x.isEmpty()) {
                    return x;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid String!");
                System.out.print("Input again: ");
            }
        }
    }

    public boolean getYN() {
        while (true) {
            try {
                String x = scanner.nextLine().trim();
                if (x.equalsIgnoreCase("y")) {
                    return true;
                } else if (x.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid String!");
                System.out.print("Input again: ");
            }
        }
    }
    
    public String getUD() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (str.equalsIgnoreCase("u")) {
                    return "u";
                } else if (str.equalsIgnoreCase("d")) {
                    return "d";
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice!");
                System.out.print("Input again: ");
            }
        }
    }
    
    public String getValidName(String id) {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                for (Student x : sm.studentList) {
                    if (x.getID().equals(id)&& x.getStudentName().equals(str)) {
                        return str;
                    } else if (x.getID().equals(id)&& !x.getStudentName().equals(str)) {
                        throw new IllegalArgumentException();
                    }
                }
                return str;
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid string!");
                System.out.print("Input again: ");
            }
        }
    }

    public String getCourse() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (str.equals("Java") || str.equals(".Net") || str.equals("C/C++")) {
                    return str;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid course!");
                System.out.print("Input again: ");
            }
        }
    }

}
