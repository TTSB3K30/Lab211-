/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0074;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class CheckInput {
    Scanner in = new Scanner(System.in);
    
    int checkInputLimit(int min , int max) {
        while(true) {
            try{
                int n = Integer.parseInt(in.nextLine());
                if(n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            }
            catch(NumberFormatException ex) {
                System.err.print("Choice number" + min + " to "+ max);
            }
        }
    }
    
    int checkInputNumber() {
        while(true) {
            try{
                int result = Integer.parseInt(in.nextLine());
                return result;
            }
            catch(NumberFormatException ex) {
                System.err.print("Re-Input: ");
            }
        }
    }
}
