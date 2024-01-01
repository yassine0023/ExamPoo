package E_Commerce.InterfacePackage;

import java.util.Scanner;

import E_Commerce.ProductPackage.AccountManager;
import E_Commerce.ProductPackage.ProductManager;

public class Admin {
    public void run_interface (){
        System.out.println("<----------------- Welcome Admin --------------------->");
        while (true ){

            System.out.println("<----------------------- Menu ----------------------->");
            System.out.println("1 -> Add Product");
            System.out.println("2 -> Remove Product");
            System.out.println("3 -> Change Product ID");
            System.out.println("4 -> Change Product Name");
            System.out.println("5 -> Change Product Price");
            System.out.println("6 -> Change Product Quantity");
            System.out.println("7 -> Display Product Information");
            System.out.println("8 -> Display List Of Users");
            System.out.println("9 -> Display List Of Admins");
            System.out.println("10 -> Delete Product");
            System.out.println("11 -> Logout");
            System.out.println("<---------------------------------------------------->");

            Scanner sc = new Scanner(System.in);
            System.out.println("Choice : ");
            int choice = sc.nextInt();
            String in;
            switch (choice) {
                case 1:
                    ProductManager.create_add_product();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Product ID: ");
                    in = sc.nextLine();
                    sc.nextLine();
                    ProductManager.delete_product(in);
                    break ;
                case 3 :
                    sc.nextLine();
                    System.out.println("Product ID: ");
                    in = sc.nextLine();
                    System.out.println("New ID: ");
                    String new_value = sc.nextLine();
                    ProductManager.updateProductField(in, new_value, 0);
                    break ;
                case 4 :
                    sc.nextLine();
                    System.out.println("Product ID: ");
                    in = sc.nextLine();
                    System.out.println("New Name: ");
                    new_value = sc.nextLine();
                    ProductManager.updateProductField(in, new_value, 1);
                    break ;
                case 5 :
                    sc.nextLine();
                    System.out.println("Product ID: ");
                    in = sc.nextLine();
                    System.out.println("New Price: ");
                    new_value = sc.nextLine();
                    ProductManager.updateProductField(in, new_value, 2);
                    break ;
                case 6 :
                    sc.nextLine();
                    System.out.println("Product ID: ");
                    in = sc.nextLine();
                    System.out.println("New Quantity: ");
                    new_value = sc.nextLine();
                    ProductManager.updateProductField(in, new_value, 3);
                    break ;
                case 7 :
                    ProductManager.display_product_information();
                    break ;
                case 8 :
                    AccountManager.display_list_of_users();
                    break ;
                case 9 :
                    AccountManager.display_list_of_admins();
                    break ;
                case 10 :
                    AccountManager.delete_account()  ;
                    break ;
                case 11 :
                    return ;
                default:
                    break;
            }

        }
    }
}