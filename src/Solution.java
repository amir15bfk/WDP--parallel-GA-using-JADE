
import java.io.Serializable;
import java.util.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amir
 */
public class Solution implements Serializable{
    public int[] sol;
    public int fitness;

    /**
     *
     */
    public Hashtable<Integer, String> listOfProdIds;
    
    public Solution() {
        this.sol = new int[Offer.listOfOffers.size()];
        Random random = new Random();
        for (int i=0;i<Offer.listOfOffers.size();i++){
            sol[i]=random.nextInt(2);
        }
        this.fitness = fitnessMessure();
        
    }
    public Solution(int [] sol) {
        this.sol = sol;
        this.fitness = fitnessMessure();
        
    }
    public final int fitnessMessure(){
        this.listOfProdIds = new Hashtable<>();
        boolean flag;
        int totalprice=0;
        for(int i=0;i<Offer.listOfOffers.size();i++){
            if(this.sol[i]==1){
                flag=true;
                for (Product p : Offer.listOfOffers.get(i).listOfProducts){
                    if(listOfProdIds.containsKey(p.id)){
                        flag=false;
                    }
                }
                
                if(flag){
                    for (Product p : Offer.listOfOffers.get(i).listOfProducts){
                        this.listOfProdIds.put(p.id,p.name);
                    }
                    totalprice+=Offer.listOfOffers.get(i).price;
                }
                
            }
        }
        return totalprice;
        
    }
    public void mutate(double mutationProbability) {
        for (int mutationIndex=0;mutationIndex<this.sol.length;mutationIndex++){
            if (Math.random() < mutationProbability) {
                if(this.sol[mutationIndex]==1) this.sol[mutationIndex]= 0;
                else this.sol[mutationIndex]= 1;
            }
        }
        this.fitness = fitnessMessure();
    }
    public void print(){
        this.listOfProdIds = new Hashtable<>();
        boolean flag;
        
        for(int i=0;i<Offer.listOfOffers.size();i++){
            if(this.sol[i]==1){
                
                flag=true;
                for (Product p : Offer.listOfOffers.get(i).listOfProducts){
                    if(listOfProdIds.containsKey(p.id)){
                        flag=false;
                    }
                }
                
                if(flag){
                    System.out.println("offer "+Offer.listOfOffers.get(i).id+" : "+Offer.listOfOffers.get(i).price+" DA");
                    for (Product p : Offer.listOfOffers.get(i).listOfProducts){
                        this.listOfProdIds.put(p.id,p.name);
                        System.out.println(" - "+p.id+" : "+p.name);
                    }
                }
                
            }
        }
        
    }
}
