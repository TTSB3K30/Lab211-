/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0023;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author admin
 */
public class Order {
    private String fruitID;
    private String fruitName;
    private double price;
    private int quantity;

    public Order() {
    }

    public Order(String fruitID, String fruitName, double price, int quantity) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
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


    public Order createOrder(Fruit fruit, int quantity) {
        this.fruitID = fruit.getFruitID();
        this.fruitName = fruit.getFruitName();
        this.price = fruit.getPrice();
        this.quantity = quantity;
        return this;
    }
    
    Hashtable<String, ArrayList<Order>> orderList = new Hashtable<>();
    //là một lớp trong Java được sử dụng để lưu trữ các cặp khóa-giá trị
    //Trong order khóa là tên khách hàng và giá trị là list hóa đơn
    private Validation validation = new Validation();

    public void displayOrders() {
        try {
            for (String name : orderList.keySet()) {
                System.out.println("Customer: " + name);
                ArrayList<Order> OL = orderList.get(name);
                display(OL);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void display(ArrayList<Order> OL) {
        try {
            double total = 0;
            System.out.println("Product | Quantity | Price | Amount");
            for (Order x : OL) {
                String Price = String.format("%.2f$", x.getPrice());// %.2f: Định dạng số thập phân với 2 chữ số thập phân (.2f).
                System.out.println(x.getFruitName() + "\t\t" + x.getQuantity() + "\t\t" + Price + "\t\t" + x.getQuantity());
                total += x.getPrice() * x.getQuantity();
            }
            String formattedPrice = String.format("%.2f$", total);
            System.out.println("Total: " + formattedPrice);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void shopping(Fruit FL) {
        try {
            ArrayList<Order> orderArrayList = new ArrayList<>();
            // Đặt ArrayList<Order> orderArrayList vào trong hàm shopping đề ngừa trường hợp tất cả order
            // gộp chung với nhau
            String id;
            while (true) {
                if (FL.fruitList.isEmpty()) {
                    System.err.println("No fruit!");
                    break;
                }
                FL.displayFruits();
                System.out.print("Select item to buy: ");
                id = validation.getString();
                Fruit fruit = FL.getFruit(id);
                System.out.println("You selected: " + fruit.getFruitName());
                System.out.print("Please input quantity: ");
                int quantity = validation.getIntInRange(0, fruit.getQuantity());//Chỉ đc nhập số lượng hoa quả có trong cửa hàng
                buyFruit(FL, orderArrayList, id, quantity);
                System.out.println("Do you want to continue (Y/N)? ");
                if (!validation.getYN()) {
                    break;
                }
            }
            if (orderArrayList.isEmpty()) {
                return;
            }
            display(orderArrayList);
            System.out.print("Enter name: ");
            String name = validation.getString();
            orderList.put(name, orderArrayList);//Đặt ds đơn hàng theo tên vào trong orderlist
            System.err.println("Added successfully!");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void buyFruit(Fruit fruitList, ArrayList<Order> orderArrayList, String id, int quantity) {
        try {
            Fruit fruit = fruitList.getFruit(id);
            if (fruit == null) {
                System.out.println("No fruit!");
                return;
            }
            Order order1 = getOrderByID(orderArrayList, id);//Kiểm tra xem ID có trùng vs ID trong đơn hàng
            if (order1 != null) {//Nếu trùng thì cộng thêm số lượng
                order1.setQuantity(order1.getQuantity() + quantity);
            } else {//Không thì tạo sp ms
                Order newOrder = new Order();
                newOrder.createOrder(fruit, quantity);
                orderArrayList.add(newOrder);
            }
            if ((fruit.getQuantity() - quantity) == 0) {//Kiểm tra xem Fruit trong cửa hàng còn ko sau khi khách mua
                fruitList.removeFruit(fruit);//Ko còn thì xóa
            } else {
                fruit.setQuantity(fruit.getQuantity() - quantity);//Còn thì trừ đi số lượng đã mua
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public Order getOrderByID(ArrayList<Order> orderArrayList, String id) {
        for (Order x : orderArrayList) {
            if (x.getFruitID() == id) {
                return x;
            }
        }
        return null;
    }
}
