/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0009;

/**
 *
 * @author admin
 */
public class Fibonacci {
    
    // Cách 1: Sử dụng vòng lặp for
    public static void fibonacciForLoop(int n) {
        int a = 0;//gán a = 0
        int b = 1;//gán b = 1
        for (int i = 0; i < n; i++) {//chạy vòng lặp đến n số
            System.out.print(a + " ");
            int temp = a;//gán temp = a
            a = b;// gán a = b đổi giá trị
            b = temp + b;// và b sẽ bằng tổng của temp và b
        }
    }
    
    // Cách 2: Sử dụng vòng lặp while
    public static void fibonacciWhileLoop(int n) {//tương tự vòng lặp for
        int a = 0;
        int b = 1;
        int count = 0; 
        while (count < n) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
            count++;
        }
    }
    
     // Cách 3: Sử dụng đệ quy
    //đệ quy là một hàm mà hàm đó tự gọi chính nó.
    //Một số ứng dụng có thể kể đến gồm: Thuật toán 
    //Tìm kiếm và Sắp xếp(Binary Search, Quick Sort, Merge Sort)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {//nếu n <= 1 thì trả về giá trị của n
            return n;
        } else {//nếu không trả về tổng của hàm với 2 giá trị là n-1 và n-2 
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }
    
    
    public static void main(String[] args) {
        // In 45 số đầu tiên trong dãy Fibonacci bằng vòng lặp for
        System.out.println("Dãy Fibonacci (vòng lặp for):");
        fibonacciForLoop(45);
        
        // In 45 số đầu tiên trong dãy Fibonacci bằng vòng lặp while
        System.out.println("\nDãy Fibonacci (vòng lặp while):");
        fibonacciWhileLoop(45);

        // In 45 số đầu tiên trong dãy Fibonacci bằng đệ quy
        System.out.println("\nDãy Fibonacci (đệ quy):");
        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
    }
    
}
