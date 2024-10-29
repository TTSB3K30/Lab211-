/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0023;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        try {
            Fruit FL = new Fruit();
            Order OL = new Order();
            Validation validation = new Validation();
            while (true) {
                System.out.println();
                System.out.println("===============FRUIT SHOP SYSTEM==================\n" 
                        + "1. Create fruit\n"
                        + "2. View order\n"
                        + "3. Shopping (for buyer)\n"
                        + "4. Exit");
                System.out.println("Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program.");
                System.out.print("> Your choice: ");
                int choice = validation.getIntInRange(1, 4);
                switch (choice) {
                    case 1:
                        while (true) {
                            Fruit fruit = new Fruit();
                            fruit.createFruit();
                            FL.addFruit(fruit);
                            System.err.println("Added successfully!");
                            System.out.println("Do you want to continue (Y/N)? ");
                            if (!validation.getYN()) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        if (OL.orderList.isEmpty()) {
                            System.err.println("No order!");
                        } else {
                            OL.displayOrders();
                        }
                        break;
                    case 3:
//                        if (FL.fruitList.isEmpty()) {
//                            System.err.println("No fruit!");
//                            break;
//                        }
                        OL.shopping(FL);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.err.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
   
}
