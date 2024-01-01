package E_Commerce.AccountPackage;

import E_Commerce.Utils.CsvUtils;
import java.util.Arrays;
import java.util.List;

public class AccountManager {
    static String UserAccountsfilePath = "DataBase/AccountsDataBase/CustomerAccounts.csv";
    static String AdminAccountsfilePath = "DataBase/AccountsDataBase/AdminAccounts.csv";

    public static void create_user_account(){
        CustomerAccount a = new CustomerAccount();
        AccountManager.save_new_account(a , UserAccountsfilePath);
    }

    public static void create_admin_account(){
        AdminAccount a = new AdminAccount();
        AccountManager.save_new_account(a, AdminAccountsfilePath);
    }

    public static void save_new_account(Account a , String csv_file_path){
        String [] data = {String.valueOf(a.id) , a.username , a.password };
        CsvUtils.writeCSV(Arrays.asList(data) , csv_file_path);
    }

    public static void delete_admin_account(Account a ){
        List<String> data = Arrays.asList(String.valueOf(a.id) , a.username , a.password);
        int index_line = CsvUtils.find_index_line(data , AdminAccountsfilePath);
        if (index_line >= 0 ){
            CsvUtils.removeLineFromCSV(index_line, AdminAccountsfilePath);
        }
    }

    public static String find_account(Account a ){
        List<String> login_data = Arrays.asList(String.valueOf(a.id) , a.username , a.password );
        int index_line = CsvUtils.find_index_line(login_data , AdminAccountsfilePath);
        if (index_line >= 0 ){
            return "Admin Logged In";
        }
        index_line = CsvUtils.find_index_line(login_data , UserAccountsfilePath);
        if (index_line >= 0 ){
            return "Customer Logged In";
        }
        else {
            return "ERROR";
        }
    }

    public static void delete_user_account(Account a ){
        List<String> data = Arrays.asList(String.valueOf(a.id) , a.username , a.password);
        int index_line = CsvUtils.find_index_line(data , UserAccountsfilePath);
        if (index_line >= 0 ){
            CsvUtils.removeLineFromCSV(index_line, UserAccountsfilePath);

        }
    }

    public static void delete_account(){
        Account a = new Account();
        delete_admin_account(a);
        delete_user_account(a);
    }

    public static void display_list_of_users() {
        List<List<String>> data = CsvUtils.readCSV(UserAccountsfilePath);
        for (List<String> line : data) {
            System.out.println("ID: " + line.get(0) + " Username: " + line.get(1));
        }
    }

    public static void display_list_of_admins() {
        List<List<String>> data = CsvUtils.readCSV(AdminAccountsfilePath);
        for (List<String> line : data) {
            System.out.println("ID: " + line.get(0) + " Username: " + line.get(1));
        }
    }













}