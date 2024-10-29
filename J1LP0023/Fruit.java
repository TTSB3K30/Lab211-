/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0023;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class Fruit {
    private String fruitID;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitID, String fruitName, double price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    private Validation validation = new Validation();

    public void createFruit() {
        System.out.print("Input fruit id: ");
        this.fruitID = validation.getString();
        System.out.print("Input fruit name: ");
        this.fruitName = validation.getString();
        System.out.print("Input price: ");
        this.price = validation.getDouble();
        System.out.print("Input quantity: ");
        this.quantity = validation.getInt();
        System.out.print("Input origin: ");
        this.origin = validation.getString();

    }
    
    ArrayList<Fruit> fruitList = new ArrayList<>();
    
    public void addFruit(Fruit fruit) {
        try {
            Fruit newFruit = checkDupliatedFruit(fruit);
            if (newFruit != null) { // Trùng ID và tên
                newFruit.setQuantity(newFruit.getQuantity() + fruit.getQuantity());
                newFruit.setPrice(fruit.getPrice());
                newFruit.setOrigin(fruit.getOrigin());
            } else {
                boolean idExists = false; 
                for (Fruit x : fruitList) {
                    if (x.getFruitID().equals(fruit.getFruitID())) { // Kiểm tra ID trùng
                        idExists = true;
                        break; // Thoát khỏi vòng lặp nếu ID trùng
                    }
                }
                if (idExists) {
                    System.out.println("ID đã tồn tại với trái cây khác.");
                    return; // Thoát khỏi hàm addFruit
                } else {
                    fruitList.add(fruit);
                }
            }
            displayFruits();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
   
    public void displayFruits() {
        try {
            System.out.println("| ++ Item ++ | ++ Fruit name ++ | ++ Origin ++ | ++ Price ++ ");
            sortList();
            fruitList.forEach((x) -> {
                //ForEach đây là 1 phthức của Interable (mà arraylist thực hiện) 
                //Lambda expression(Là các hàm ẩn) vt code ngắn ngọn và linh hoạt hơn
                String formattedPrice = String.format("%.2f$", x.getPrice());
                System.out.println(x.getFruitID() + "\t\t" + x.getFruitName() + "\t\t" + x.getOrigin() + "\t\t" + formattedPrice);
            });
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void sortList() {
        try {
            Collections.sort(fruitList, (Fruit o1, Fruit o2) -> {
                return o1.getFruitID().compareToIgnoreCase(o2.getFruitID());
            });
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    private Fruit checkDupliatedFruit(Fruit fruit) {
        for (Fruit x : fruitList) {
            if (x.getFruitID().equalsIgnoreCase(fruit.getFruitID())) {
                if (x.getFruitName().equals(fruit.getFruitName())) {
                    return x; // Trùng ID và tên, trả về fruit đã có
                } 
            }
        }
        return null;
    }

    public Fruit getFruit(String id) {//Lấy hoa quả theo ID
        for (Fruit x : fruitList) {
            if (x.getFruitID() == id) {
                return x;
            }
        }
        return null;
    }

    public void removeFruit(Fruit fruit) {
        fruitList.remove(fruit);
    }
}
