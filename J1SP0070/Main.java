/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0070;

import java.util.Locale;//đại diện cho một ngôn ngữ và khu vực cụ thể trên tg
import java.util.ResourceBundle;//là tệp .properties Java chứa dữ liệu theo ngôn ngữ cụ thể

/**
 *
 * @author admin    
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("------------ Login Program -------------\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
        
        int choice = Validation.inputInt("Please choice one option: ",
                "Just 1--> 3", "Invlaid", 1, 3); 
        //nhập lựa chọn
        switch(choice){
            case 1:
                // Thiết lập ngôn ngữ mặc định cho hệ thống là tiếng Việt (vi).
                Locale.setDefault(new Locale("vi"));
                break;
            case 2:
                // Thiết lập ngôn ngữ mặc định cho hệ thống là tiếng Anh (en).
                Locale.setDefault(new Locale("en"));
                break;
            case 3:
                System.exit(0);
                break;
        }
//        ResourceBundle rb = ResourceBundle.getBundle("J1SP0070/Langguage");
        //Tải các thông điệp từ file Langguage.properties trong thư mục ebank
        new Account().login(Validation.rb);
    }
}
