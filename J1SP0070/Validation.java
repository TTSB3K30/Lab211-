/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0070;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {
     static ResourceBundle rb  = ResourceBundle.getBundle("J1SP0070/Langguage");
    //Đảm bảo rằng rb chỉ được khởi tạo 1 lần duy nhất, ngay khi class chạy tránh tình trạng khởi tạo nhiều lần hoặc sai

    
    public static final int CAPTCHA_LEN = 5;
    public static final String ACCOUNT_NUM = "^[0-9]{10}$";
    //kiểm tra xem một chuỗi có phải là một số nguyên có 10 chữ số hay không.
    //^ đánh dấu bắt đầu, $ đánh dấu kết thúc, {10} xác định số lần lặp của ký tự hoặc nhóm ký tự trước đó.
    // [0-9]{10}: Phải có chính xác 10 số trong chuỗi
    
    public static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
    //?=.*[A-Za-z] kiểm tra xem chuỗi có chứa ít nhất một chữ cái (A-Z, a-z) hay không.
    //?=.*\\\\d kiểm tra xem chuỗi có chứa ít nhất một chữ số hay không.
    //A-Za-z\\\\d Tập hợp các ký tự cho phép gồm chữ và số 
    // Có tối thiểu 8 ký tự và tối đa 31 ký tự
    
    public static final String CAPTCHA = "^[A-Za-z0-9]{5}$";
    
    public static int inputInt(String mesinfo, String mesErrorRange,String mesErrorNum, int min, int max){
        Scanner sc = new Scanner(System.in);
        do {   //tiếp tục chạy đến lúc nhập số nguyên trong phạm vi cho phép
            try {// xử lý ngoại lệ NumberFormatException nếu người dùng nhập ko phải số
                System.out.print(mesinfo);
                int num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.err.println(mesErrorRange);//Thông báo nếu số nhập không nằm trong phạm vi
                }
            } catch (NumberFormatException exception) {
                System.err.println(mesErrorNum);
            }
        } while (true);
    }
    
    public static String inputString(String mesInfo, String mesError, final String REGAX){
        Scanner sc = new Scanner(System.in);
        System.out.println(mesInfo);// thông báo nhập chuỗi
        do {            
            String str = sc.nextLine();
            if (str.matches(REGAX)) { //sử dụng matches kiểm tra chuỗi có khớp với biểu thức chính quy REGAX
                return str;
            }
            System.err.println(mesError);
            System.out.print(rb.getString("Re-Input"));
        } while (true);
        
    }
    
    // Hàm checkCaptcha
    public static String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaInput.contains(captchaGenerate)) {
            return ""; // Mã captcha hợp lệ
        } else {
            return rb.getString("captchaInvalid");// Lỗi mã captcha
        }
    }

}
