
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amir
 */
public class Offer {
    public int price;
    public static int counter =0;
    public static ArrayList<Offer> listOfOffers = new ArrayList<Offer>(); 
    public int id;
    public ArrayList<Product> listOfProducts; 
    public Offer(int price){
        this.id = counter;
        counter ++;
        this.price =price;
        listOfProducts = new ArrayList<Product>();
        listOfOffers.add(this);
    }
    public static void reset(){
        listOfOffers = new ArrayList<Offer>(); 
        counter =0;
    }
    public void add(String name){
        for (Product p:Product.listOfProducts){
            if (p.name.equals(name)){
                listOfProducts.add(p);
                return;
            }
        }
        listOfProducts.add(new Product(name));
        
    }
    public static void test1(){
        Offer.reset();
        Product.reset();
        Offer o1 = new Offer(5000);
        o1.add("ball");
        o1.add("white t-shirt");
        o1.add("ball jacket");

        Offer o2 = new Offer(2000);
        o2.add("ball");
        o2.add("white mask");
        o2.add("the leather backpack");

        Offer o3 = new Offer(3500);
        o3.add("basketball");
        o3.add("red hoodie");
        o3.add("ball");

        Offer o4 = new Offer(8000);
        o4.add("gym equipment");
        o4.add("yoga mat");
        o4.add("dumbbell set");

        Offer o5 = new Offer(10000);
        o5.add("smartwatch");
        o5.add("wireless headphones");
        o5.add("office chair");
        o5.add("ball");

        Offer o6 = new Offer(1500);
        o6.add("bookshelf");
        o6.add("desk lamp");
        o6.add("office chair");
        o6.add("yoga mat");

        Offer o7 = new Offer(2500);
        o7.add("running shoes");
        o7.add("fitness tracker");
        o7.add("dumbbell set");

        Offer o8 = new Offer(4000);
        o8.add("yoga mat");
        o8.add("water bottle");
        o8.add("yoga pants");

        Offer o9 = new Offer(6000);
        o9.add("sneakers");
        o9.add("t-shirt");
        o9.add("sports bag");
        o9.add("sweatpants");

        Offer o10 = new Offer(9000);
        o10.add("smartphone");
        o10.add("laptop");
        o10.add("smartwatch");
        o10.add("tablet");
        o10.add("wireless headphones");
        Offer o11 = new Offer(4500);
        o11.add("basketball");
        o11.add("red hoodie");
        o11.add("running shoes");

        Offer o12 = new Offer(6000);
        o12.add("dumbbell set");
        o12.add("yoga mat");
        o12.add("water bottle");
        o12.add("fitness tracker");

        Offer o13 = new Offer(8000);
        o13.add("smartwatch");
        o13.add("wireless headphones");
        o13.add("office chair");
        o13.add("yoga mat");
        o13.add("dumbbell set");

        Offer o14 = new Offer(3500);
        o14.add("soccer ball");
        o14.add("cleats");
        o14.add("soccer socks");

        Offer o15 = new Offer(7000);
        o15.add("laptop");
        o15.add("printer");
        o15.add("desk");
        o15.add("office chair");

        Offer o16 = new Offer(5000);
        o16.add("tennis racket");
        o16.add("tennis balls");
        o16.add("sweatband");
        o16.add("water bottle");

        Offer o17 = new Offer(2500);
        o17.add("skipping rope");
        o17.add("fitness band");
        o17.add("yoga mat");

        Offer o18 = new Offer(9000);
        o18.add("smartphone");
        o18.add("laptop");
        o18.add("smartwatch");
        o18.add("tablet");
        o18.add("wireless headphones");
        o18.add("charger");

        Offer o19 = new Offer(5500);
        o19.add("baseball bat");
        o19.add("glove");
        o19.add("baseball hat");
        o19.add("water bottle");

        Offer o20 = new Offer(7500);
        o20.add("gym membership");
        o20.add("personal training session");
        o20.add("yoga mat");
        o20.add("water bottle");
    }
    public static void test2(){
        Offer.reset();
        Product.reset();

        Offer o1 = new Offer(6000);
        o1.add("smartwatch");
        o1.add("wireless earbuds");
        o1.add("office chair");

        Offer o2 = new Offer(3000);
        o2.add("dumbbell set");
        o2.add("yoga mat");
        o2.add("water bottle");

        Offer o3 = new Offer(4500);
        o3.add("basketball");
        o3.add("red hoodie");
        o3.add("running shoes");

        Offer o4 = new Offer(8000);
        o4.add("gaming laptop");
        o4.add("gaming mouse");
        o4.add("gaming keyboard");

        Offer o5 = new Offer(12000);
        o5.add("smartphone");
        o5.add("smartwatch");
        o5.add("tablet");
        o5.add("wireless earbuds");

        Offer o6 = new Offer(2000);
        o6.add("bookshelf");
        o6.add("desk lamp");
        o6.add("office chair");
        o6.add("yoga mat");

        Offer o7 = new Offer(4000);
        o7.add("running shoes");
        o7.add("fitness tracker");
        o7.add("dumbbell set");

        Offer o8 = new Offer(4500);
        o8.add("laptop");
        o8.add("printer");
        o8.add("desk");
        o8.add("office chair");

        Offer o9 = new Offer(5000);
        o9.add("camera");
        o9.add("tripod");
        o9.add("memory card");

        Offer o10 = new Offer(10000);
        o10.add("smartphone");
        o10.add("laptop");
        o10.add("smartwatch");
        o10.add("tablet");
        o10.add("wireless earbuds");
        o10.add("charger");

        Offer o11 = new Offer(3500);
        o11.add("soccer ball");
        o11.add("cleats");
        o11.add("soccer socks");

        Offer o12 = new Offer(6000);
        o12.add("dumbbell set");
        o12.add("yoga mat");
        o12.add("water bottle");
        o12.add("fitness tracker");

        Offer o13 = new Offer(8000);
        o13.add("smartwatch");
        o13.add("wireless earbuds");
        o13.add("office chair");
        o13.add("yoga mat");
        o13.add("dumbbell set");

        Offer o14 = new Offer(2500);
        o14.add("skipping rope");
        o14.add("fitness band");
        o14.add("yoga mat");

        Offer o15 = new Offer(7000);
        o15.add("laptop");
        o15.add("printer");
        o15.add("desk");
        o15.add("office chair");

        Offer o16 = new Offer(5000);
        o16.add("tennis racket");
        o16.add("tennis balls");
        o16.add("sweatband");
        o16.add("water bottle");

        Offer o17 = new Offer(4500);
        o17.add("gaming console");
        o17.add("gaming headset");
        o17.add("gaming chair");
    }
    @Override
    public String toString(){
        String s= this.id+" price : "+this.price+" DA";
        for (Product p:this.listOfProducts){
            s+="\n - "+p.name;
        }
        return s+"\n";
    }
}
