/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0010;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class LinearSearch {
    // Hàm kiểm tra đầu vào cho kích thước mảng
    public static int checkInputArr() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input size array: ");
                String n = scanner.nextLine().trim();
                if (n.isEmpty()) {
                    System.err.println("Empty!!!");
                } else {
                    int number = Integer.parseInt(n);
                    if (number > 0 && number < Integer.MAX_VALUE) {
                        return number;
                    } else {
                        System.out.println("Input size array > 0");
                        continue;
                    }
                }
            } catch (NumberFormatException exception) {
                System.err.println("Enter Again Number!!!");
            }
        }
    }

    // Hàm kiểm tra đầu vào cho số cần tìm
    public static int checkInputSearch() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input number search: ");
                String n = scanner.nextLine().trim();
                if (n.isEmpty()) {
                    System.err.println("Empty!!!");
                } else {
                    int number = Integer.parseInt(n);
                    if (number > Integer.MIN_VALUE && number < Integer.MAX_VALUE) {
                        return number;
                    } else {
                        System.out.println("Input number search > 0");
                        continue;
                    }
                }
            } catch (NumberFormatException exception) {
                System.err.println("Enter Again Number!!!");
            }
        }
    }

    // Hàm để tạo mảng và thực hiện tìm kiếm tuyến tính
    public static List<Integer> performLinearSearch(int length, int index) {
        int[] array = createRandomArray(length); // Tạo mảng ngẫu nhiên
        System.out.println("The array: ");
        Displayarray(array);

        return LinearSearch(array, index); // Thực hiện tìm kiếm tuyến tính
    }

    // Hàm tạo mảng ngẫu nhiên
    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        return array;
    }

    public static void Displayarray(int[] arr) { // Hàm in ra các giá trị trong mảng
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i <= arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    // Hàm tìm kiếm tuyến tính, trả về danh sách các vị trí tìm thấy
    public static List<Integer> LinearSearch(int[] arr, int key) {
        List<Integer> foundIndexes = new ArrayList<>();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) { // Nếu tìm thấy
                foundIndexes.add(i); // Thêm vị trí vào danh sách
            }
        }
        return foundIndexes;
    }

    public static void main(String[] args) {
        int length = checkInputArr();
        int index = checkInputSearch();

        // Gọi hàm để tạo mảng và thực hiện tìm kiếm tuyến tính
        List<Integer> foundIndexes = performLinearSearch(length, index); 

        if (!foundIndexes.isEmpty()) {
            System.out.println("\nFound " + index + " at indexes: " + foundIndexes);
        } else {
            System.out.println("\nNot Found " + index + " in array");
        }
    }
}
