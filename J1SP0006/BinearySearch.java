/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BinearySearch {
    private int [] array;
    
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
    
    // Hàm tạo mảng ngẫu nhiên
    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        return array;
    }
    
    //Sắp xếp lại mảng
    void sortByBubbleSort() {
        int temp = 0;
        int n = array.length;
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 1 ; j < (n-i) ; j++){
                if(array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp ;
                }
            }
        }
    }
    
    // Hàm in mảng
    void displayInd(String message) {
        System.out.print(message + Arrays.toString(array));

    }
    
    //Hàm tìm kiếm
    List<Integer> binarySearch(int value, int left, int right) {
        List<Integer> foundIndexes = new ArrayList<>();
        while(left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                foundIndexes.add(middle); // Thêm vị trí vào danh sách
                // Tìm kiếm ở phần bên trái
                List<Integer> leftIndexes = binarySearch(value, left, middle - 1);
                foundIndexes.addAll(leftIndexes);
                // Tìm kiếm ở phần bên phải
                List<Integer> rightIndexes = binarySearch(value, middle + 1, right);
                foundIndexes.addAll(rightIndexes);
                return foundIndexes; // Trả về danh sách
            } else if (array[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return foundIndexes;
    }
    
    // Hiển thị kết quả tìm kiếm
    void displayIndex(int value) {
        List<Integer> foundIndexes = binarySearch(value, 0, array.length - 1);
        if (foundIndexes.isEmpty()) {
            System.out.println("\nNot Found");
        } else {
            System.out.println("\nFound " + value + " at indexes: " + foundIndexes);
        }
    }
    
    public static void main(String[] args) {
        BinearySearch bs = new BinearySearch();
        int sizeArray = checkInputArr();

       bs.array = createRandomArray(sizeArray); // Tạo mảng ngẫu nhiên và gán cho mảng array trong đối tượng bs

        int numberSearch = checkInputSearch();

        bs.sortByBubbleSort();

        bs.displayInd("Sorted : ");

        bs.displayIndex(numberSearch);
    }
    
}
