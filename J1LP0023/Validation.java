/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0023;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {
    private Scanner scanner = new Scanner(System.in);

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

    public int getInt() {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine());
                if (x > 0) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid positive integer!");
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
    

    public double getDouble() {
        while (true) {
            try {
                double x = Double.parseDouble(scanner.nextLine());
                if (x > 0) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid double!");
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
}
