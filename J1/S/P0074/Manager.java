/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0074;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Manager {
    CheckInput checkInput = new CheckInput();

    Scanner scanner = new Scanner(System.in);

    int[][] inputMatrix(int n, int expectedRows, int expectedCols, boolean validateDimensions, int choice) {
        int rows, cols;
        //Biến validateDimensions xác định xem có cần kiểm tra kích thước ma trận hay không.
        while (true) {
            System.out.print("Enter Row Matrix " + n + ": ");
            rows = checkInput.checkInputNumber();
            System.out.print("Enter Column Matrix " + n + ": ");
            cols = checkInput.checkInputNumber();
            
            if ((choice == 1 || choice == 2) && (!validateDimensions || (rows == expectedRows && cols == expectedCols))) {
                break;
            }
            if ((choice == 3) && (!validateDimensions || (rows == expectedCols))) {
                break;
            }
            System.out.println("Matrix dimensions must match the first matrix. Please re-enter.");
        }

        int[][] matrix = new int[rows][cols];
        for(int i = 1 ; i <= rows ; i++) {
            for(int j = 1 ; j <= cols ; j++) {
                System.out.print("Enter Matrix " + n + "[" + i + "]" + "[" + j + "] : ");
                matrix[i-1][j-1] = checkInput.checkInputNumber();
            }
        }
        return matrix;
    }

    void displayMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("[" + matrix[i-1][j-1] + "]");
            }
            System.out.println();
        }
    }

    void addMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------------- Result -------------------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        
        int[][] result = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        displayMatrix(result);
    }

    void subMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------------- Result -------------------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        displayMatrix(result);
    }

    void mulMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------------- Result -------------------");
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

//        while (cols1 != rows2) {//Yêu cầu nhập cho đến khi cột trong ma trận 1 bằng hàng trong ma trận 2
//            System.out.println("Number of columns of matrix 1 must be equal to the number of rows of matrix 2 for multiplication.");
//            System.out.println("Re-enter the second matrix:");
//            matrix2 = inputMatrix(2, 0, 0, false,3); // Yêu cầu nhập ma trận 2
//            rows2 = matrix2.length;
//            cols2 = matrix2[0].length;
//        }

        // Proceed with matrix multiplication
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] result = new int[rows1][cols2];
        for(int i = 0 ; i < rows1 ; i++) {
            //Vòng lặp lồng nhau để duyệt qua các phần tử của ma trận kết quả.
            for(int j = 0 ; j < cols2 ; j++) {
                //Vòng lặp lặp qua các cột của ma trận kết quả.
                result[i][j] = 0;
                for(int k = 0 ; k < cols1 ; k++) {
                    //thực hiện phép nhân từng phần tử của ma trận thứ nhất và ma trận thứ hai, sau đó cộng vào result[i][j].
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(result);
}

    void display() {
        
        while (true) {
            System.out.println("================ Caculator Program =================");
            System.out.println("1. Add Matrix");
            System.out.println("2. Subtract Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Exit");
            System.out.print("Your Choice: ");
            int choice = checkInput.checkInputLimit(1, 4);

            if (choice == 4) {
                return;
            }
            int[][] matrix1 = inputMatrix(1, 0, 0, false,choice);
            int[][] matrix2;
            if(choice == 1 || choice == 2 || choice == 3) {
                matrix2 = inputMatrix(2, matrix1.length, matrix1[0].length, true,choice);
            }
            else {
                matrix2 = inputMatrix(2, 0, 0, false,choice);
            }
            switch (choice) {
                case 1:
                    System.out.println("------------ Addition ----------------");
                    addMatrix(matrix1, matrix2);
                    break;
                case 2:
                    System.out.println("------------ Subtraction ----------------");
                    subMatrix(matrix1, matrix2);
                    break;
                case 3:
                    System.out.println("------------ Mutiplication ---------------");
                    mulMatrix(matrix1, matrix2);
                    break;
            }
        }
    }

}
