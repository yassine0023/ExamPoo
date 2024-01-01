package E_Commerce.AccountPackage;
import java.util.Scanner;

public class Account {

    protected String password;
    protected String username ;
    protected int id ;



    public Account(){
        Scanner scanner = new Scanner(System.in) ;
        //create id of customer
        System.out.println("ID : ") ;
        this.id = scanner.nextInt();
        scanner.nextLine();
        //create username of customer
        System.out.println("UserName : ") ;
        this.username = scanner.nextLine();
        //create password
        System.out.println("Password : ") ;
        String password = scanner.nextLine() ;
        this.password = password;

    }











}