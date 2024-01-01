package E_Commerce.InterfacePackage;

import java.util.Scanner;
import E_Commerce.AccountPackage.*;

public class AppInterface {
    private boolean test;

    public AppInterface() {
        this.test = true;
    }

    public boolean start() {
        System.out.println("Welcome to the E-Commerce Application !");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type [Y] if you want to continue or [N] if you want to exit:");
        String input_string = scanner.nextLine();
        if (input_string.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void runApp() {
        while (test) {
            if (!start()) {
                System.out.println("Exiting The Application.");
                break;
            }

            System.out.println("1-> Login\n2-> Sign Up");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                authentication();
            } else if (choice == 2) {
                AccountManager.create_user_account();
                authentication();
            }
        }
    }

    public void authentication() {
        Account account = new Account();
        String login_state = AccountManager.find_account(account);
        if (login_state.equals("Admin Logged In")) {
            Admin a_interface = new Admin();
            a_interface.run_interface();
        } else if (login_state.equals("Customer Logged In")) {
            Customer u_interface = new Customer();
            u_interface.runInterface();
        } else if (login_state.equals("ERROR")) {
            this.test = false;
            System.out.println("ERROR");
        }
    }
}