/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0070;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Account {
    String account,password;
    
    public Account(){
        
    }

    public Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
    
    public static List<Account> lsAccount = new ArrayList<Account>(){
        //Khai báo biến lsAccount là ds các đối tượng Account
        //new ArrayList<Account>() để khởi tạo một danh sách mới.
        {
            add(new Account("0832066666","son123456"));
            add(new Account("0832099999","tugson1234"));
            add(new Account("0832088888","tungson7273"));
            add(new Account("0832626262","tungson6789"));
            add(new Account("0832011111","tungson6666"));
        }
    };
    
    public String capcha(int length){
        String num = "0123456789"; 
        String al = "";
        char c = 'a';
        while (c <= 'z') {//duyệt qua các chữ cái từ a-z 
            al +=c;
            c++;
        }
        String cap = al + al.toUpperCase() + num;
        //ghép chuỗi để tạo chuỗi chứa tất cả các ký tự có thể dùng trong captcha
        String capcha = "";
        for (int i = 0; i < length; i++) {
            capcha += cap.charAt(new Random().nextInt(cap.length()));
            //chọn ngẫu nhiên một ký tự từ chuỗi cap và thêm vào chuỗi capcha
        }
        return capcha.toString();
    }
    
    public void login(ResourceBundle rb){//Hàm thực hiện đăng nhập
        while (true) { 
        //Tạo biến account và yêu cầu nhập stk hợp lệ
        String account = Validation.inputString(rb.getString("account"),
                rb.getString("accountInvalid"), Validation.ACCOUNT_NUM);
        //Tạo biến password và yêu cầu nhập pass hợp lệ
        String password = Validation.inputString(rb.getString("password"),
                rb.getString("passwordInvalid"),Validation.PASSWORD);
        //Tạo biến capcha ,gọi hàm capcha để tạo mã capcha ngầu nhiên
        String capcha = capcha(Validation.CAPTCHA_LEN);
        while (true) { // Vòng lặp để yêu cầu nhập lại mã capcha
            System.out.println(rb.getString("captcha") + capcha);

            Scanner sc = new Scanner(System.in); // Tạo scanner mới
            String captchaInput = sc.nextLine(); // Nhập mã capcha
            
            String check = Validation.checkCaptcha(captchaInput, capcha);

            if (check.isEmpty()) {
                // Nhập đúng mã capcha
                if (checklogin(account, password)) {
                    System.out.println(rb.getString("loginSuccess"));
                    return; // Thoát khỏi vòng lặp
                } else {
                    System.err.println(rb.getString("loginFailed"));
                    break;
                }
            } else {
                // Nhập sai mã capcha, tạo mã mới
                capcha = capcha(Validation.CAPTCHA_LEN);
                System.err.println(rb.getString("captchaInvalid"));
            }
        }
    }}

    public boolean checklogin(String account, String password) {
        //Kiểm tra đăng nhập 
        for (int i = 0; i < lsAccount.size(); i++) {
            Account a = lsAccount.get(i);
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    
}
