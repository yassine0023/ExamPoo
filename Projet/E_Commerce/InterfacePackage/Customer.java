package E_Commerce.InterfacePackage;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import E_Commerce.ProductPackage.*;

public class Customer {
    private static boolean run = true;
    private Map<Product, Integer> cart;

    public Customer() {
        this.cart = new HashMap<>();
    }

    public void runInterface() {
        System.out.println("<--------------------- Welcome User --------------------->");
        while (run) {
            System.out.println("<--------------------- Menu --------------------->");
            System.out.println("1 -> View Inventory");
            System.out.println("2 -> Add ProductPackage To Cart");
            System.out.println("3 -> Remove ProductPackage From Cart");
            System.out.println("4 -> Empty Cart");
            System.out.println("5 -> Update Quantity of a ProductPackage In Cart");
            System.out.println("6 -> Display a product's information");
            System.out.println("7 -> View Cart");
            System.out.println("8 -> Search");
            System.out.println("9 -> Make an order");
            System.out.println("10 -> Display your order history");
            System.out.println("11 -> Payment Method");
            System.out.println("12 -> Logout");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            runOnChoice(choice);
        }
    }

    public void runOnChoice(int choice) {
        switch (choice) {
            case 1:
                viewInventory();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                removeProduct();
                break;
            case 4:
                emptyCart();
                break;
            case 5:
                updateQuantity();
                break;
            case 6:
                displayProductInfo();
                break;
            case 7:
                viewCart();
                break;
            case 8:
                search();
                break;
            case 9:
                System.out.println("Under Development ! Does Not Work Currently ! Visit Later !");
                break;
            case 10:
                System.out.println("Under Development ! Does Not Work Currently ! Visit Later !");
                break;
            case 11:
                System.out.println("Under Development ! Does Not Work Currently ! Visit Later !");
                break;
            case 12:
                exit();
                break;
            default:
                System.out.println("Invalid Choice !");
                break;
        }
    }

    public void viewInventory() {
        ProductManager.display_products();
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart: ");
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("ProductPackage ID : " + product.getId() + " | ProductPackage Name : " + product.getName() +
                        " | ProductPackage Quantity : " + quantity + " | ProductPackage Price : " + product.getPrice());
            }
        }
    }

    public void updateQuantity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ProductPackage ID: ");
        String productId = sc.nextLine();
        Product product = ProductManager.find_product(productId);
        if (product != null) {
            System.out.println("Quantity : ");
            int quantity = sc.nextInt();
            cart.remove(product);
            cart.put(product, quantity);
            System.out.println("ProductPackage added to the cart.");
        } else {
            System.out.println("ProductPackage not found.");
        }
    }

    public void displayProductInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ProductPackage ID: ");
        String productId = sc.nextLine();
        Product product = ProductManager.find_product(productId);
        if (product != null) {
            System.out.println("ProductPackage info: ");
            System.out.println("ID: " + product.id);
            System.out.println("Name: " + product.name);
            System.out.println("Price: " + product.price);
            System.out.println("Quantity: " + product.quantity);
        } else {
            System.out.println("ProductPackage not found.");
        }
    }

    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ProductPackage ID: ");
        String productId = sc.nextLine();
        Product product = ProductManager.find_product(productId);
        if (product != null) {
            System.out.println("ProductPackage found.");
        } else {
            System.out.println("ProductPackage not found.");
        }
    }


    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ProductPackage ID: ");
        String productId = sc.nextLine();
        Product product = ProductManager.find_product(productId);
        if (product != null) {
            System.out.println("Quantity : ");
            int quantity = sc.nextInt();
            cart.put(product, quantity);
            System.out.println("ProductPackage added to the cart.");
        } else {
            System.out.println("ProductPackage not found.");
        }
    }

    public void removeProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ProductPackage ID: ");
        String productId = sc.nextLine();
        Product product = ProductManager.find_product(productId);
        if (product != null && cart.containsKey(product)) {
            cart.remove(product);
            System.out.println("ProductPackage removed from the cart.");
        } else {
            System.out.println("ProductPackage not found in the cart.");
        }
    }

    public void emptyCart() {
        cart.clear();
        System.out.println("Cart is now empty.");
    }

    public void exit() {
        System.out.println("Exiting the program. Thank you for using the User InterfacePackage.");
        run = false;
    }
}