package E_Commerce.ProductPackage;
import java.util.Scanner;

public class Product {
    public String id ;

    public String name ;
    public double price;
    public double quantity ;

    public Product (){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Product's ID : ") ;
        this.id = scanner.nextLine();
        System.out.println("Product's Name : ") ;
        this.name= scanner.nextLine();
        System.out.println("Price : ");
        this.price = scanner.nextDouble();
        System.out.println("Quantity : ");
        this.quantity = scanner.nextDouble();

    }

    public Product(String id,String name , String price , String quantity){
        this.id = id ;
        this.name = name ;
        this.price = Double.parseDouble(price);
        this.quantity = Double.parseDouble(quantity);
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public double getQuantity(){
        return this.quantity;
    }
}