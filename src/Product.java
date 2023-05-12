
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amir
 */
public class Product {
    public static int counter =0;
    public static ArrayList<Product> listOfProducts = new ArrayList<Product>(); 
    public int id;
    public String name; 
    public Product(String name){
        this.id = counter;
        counter ++;
        this.name =name;
        listOfProducts.add(this);
    }
    public static void reset(){
        counter =0;
        listOfProducts = new ArrayList<Product>();
    }
 
}
