package E_Commerce.ProductPackage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import E_Commerce.Utils.CsvUtils;

public class ProductManager {
    static String filePath = "DataBase/ProductsDataBase/Inventory.csv";

    public static void create_add_product(){
        Product p = new Product();
        ProductManager.save_product(p);
    }

    public static void delete_product(String id ){

        int index = CsvUtils.find_index_line(Arrays.asList(id), filePath);
        CsvUtils.removeLineFromCSV(index, filePath);
    }




    public static void save_product(Product p ){

        boolean product_alreadty_exists = ProductManager.check_product_exists(p);
        if (product_alreadty_exists == false){
            String [] data = {p.id , p.name, String.valueOf(p.price) , String.valueOf(p.quantity) };
            CsvUtils.writeCSV(Arrays.asList(data) , filePath);
        }
        else {
            System.out.println("ProductPackage Already Exists");

        }

    }

    public static void display_product_information(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ProductPackage's ID : ") ;
        String id = scanner.nextLine();
        int index = CsvUtils.find_index_line(Arrays.asList(id), filePath);
        List<List<String>> data = CsvUtils.readCSV(filePath);
        List<String> Product_data = data.get(index);
        System.out.println("ProductPackage's Name : " + Product_data.get(1)) ;
        System.out.println("Price : " + Product_data.get(2));
        System.out.println("Quantity : " + Product_data.get(3));
    }

    public static void updateProductId(String id, String changedValue) {
        updateProductField(id, changedValue, 0);
    }

    public static void updateProductName(String id, String changedValue) {
        updateProductField(id, changedValue, 1);
    }

    public static void updateProductPrice(String id, String changedValue) {
        updateProductField(id, changedValue, 2);
    }

    public static void updateProductQuantity(String id, String changedValue) {
        updateProductField(id, changedValue, 3);
    }

    public static void updateProductField(String id, String changedValue, int fieldIndex) {
        int index = CsvUtils.find_index_line(Arrays.asList(id), filePath);
        System.out.println("index: " + index);
        if (index >= 0) {
            List<List<String>> data = CsvUtils.readCSV(filePath);
            List<String> newData;

            switch (fieldIndex) {
                case 0:
                    newData = UpdateId(data.get(index), changedValue);
                    break;
                case 1:
                    newData = UpdateName(data.get(index), changedValue);
                    break;
                case 2:
                    newData = UpdatePrice(data.get(index), changedValue);
                    break;
                case 3:
                    newData = UpdateQuantity(data.get(index), changedValue);
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    return;
            }

            CsvUtils.removeLineFromCSV(index, filePath);
            String[] stringArray = newData.toArray(new String[0]);
            CsvUtils.appendToCSV(stringArray, id);
        } else {
            System.out.println("ProductPackage ID Doesn't Exist!!");
        }
    }

    protected static List<String> UpdateId(List<String> data, String changedValue) {
        data.set(0, changedValue);
        return data;
    }
    protected static List<String> UpdateName(List<String> data, String changedValue) {
        data.set(1, changedValue);
        return data;
    }

    protected static List<String> UpdateQuantity(List<String> data, String changedValue) {
        data.set(3, changedValue);
        return data;
    }

    protected static List<String> UpdatePrice(List<String> data, String changedValue) {
        data.set(2, changedValue);
        return data;
    }



    protected static boolean check_product_exists(Product p ){
        List<String> data = Arrays.asList(p.id , p.name);
        int index_line = CsvUtils.find_index_line(data, filePath);
        return index_line >= 0 ;
    }

    public static  Product find_product(String name ){
        int index =  CsvUtils.find_index_line(Arrays.asList(name), filePath);
        List<List<String>> data = CsvUtils.readCSV(filePath);
        List<String> Product_data = data.get(index);
        Product p = new Product(Product_data.get(0),Product_data.get(1), Product_data.get(2), Product_data.get(3));
        return p ;
    }


    public static void display_products() {
        List<List<String>> data = CsvUtils.readCSV(filePath);
        for (List<String> line : data) {
            System.out.println("ID: " + line.get(0) + " Name: " + line.get(1) + " Price: " + line.get(2) + " Quantity: " + line.get(3));
        }
    }
}