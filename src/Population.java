
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amir
 */

public class Population extends Agent{
    public ArrayList<Solution> population;
    public static double crossoverProbability=0.7;
    public static double mutationProbability=0.05;
    public static double migrationProbability=0.05;
    public static int maxGenerations=100;    
    public static int popsize=100;
    public Solution globalBest = new Solution();
    protected void setup(){
        System.out.println("hi ,i'm "+getAID().getLocalName());
        int iter = 0;
        initPop(100);
        while (iter < maxGenerations) {
            this.newgen();
            iter++;
            for(Solution sol:population){
                if( Math.random()<migrationProbability){
                    ACLMessage msg = new ACLMessage(ACLMessage.CFP);
                    try {
                        msg.setContentObject((Serializable) sol);
                    } catch (IOException ex) {
                        Logger.getLogger(Population.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int randpop = (int) (Math.random() * 10);
                    msg.addReceiver(new AID("pop"+randpop, AID.ISLOCALNAME));
                    send(msg);
                    System.out.println("from "+getAID().getLocalName()+"to pop"+randpop);
                }
            }
            ACLMessage msg = receive();
            while (msg!= null){
                try {
                    Solution sol = (Solution) msg.getContentObject();
                } catch (UnreadableException ex) {
                    Logger.getLogger(Population.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                msg = receive();
            }
        }
        ACLMessage msg = new ACLMessage(ACLMessage.CFP);
        try {
            msg.setContentObject((Serializable) this.globalBest);
        } catch (IOException ex) {
            Logger.getLogger(Population.class.getName()).log(Level.SEVERE, null, ex);
        }
        msg.addReceiver(new AID("Master", AID.ISLOCALNAME));
        send(msg);
        System.out.println(this.globalBest.fitness+" "+Arrays.toString(this.globalBest.sol));
    }
    public void initPop(int size){
        population = new ArrayList<Solution>();
        for (int i=0;i<size;i++){
            population.add(new Solution());
        }
    }
    private Solution selectParent() {
            int k = 5;
            Solution[] tournament = new Solution[k];
            for (int i = 0; i < k; i++) {
                tournament[i] = population.get((int) (Math.random() * population.size()));
            }
            Arrays.sort(tournament, Comparator.comparingInt(individual -> -individual.fitness));
            return tournament[0];
    }
    private Solution crossover(Solution parent1, Solution parent2) {
        int[] child = new int[Offer.listOfOffers.size()];
        int crossoverPoint = (int) (Math.random() * (Offer.listOfOffers.size() - 1)) + 1;
        for (int i = 0; i < crossoverPoint; i++) {
            child[i] = parent1.sol[i];
        }
        for (int i = crossoverPoint; i < Offer.listOfOffers.size(); i++) {
            child[i] = parent2.sol[i];
        }
        return new Solution(child);
    }
    public void newgen() {
        ArrayList<Solution> newPopulation = new ArrayList<>();
        
        newPopulation.add(this.globalBest);
        while (newPopulation.size() < population.size()) {
            Solution parent1 = selectParent();
            Solution parent2 = selectParent();
            Solution child;
            if (Math.random() < crossoverProbability) {
                child = crossover(parent1, parent2);

            } else {

                child = new Solution(Arrays.copyOf(parent1.sol, parent1.sol.length));
            }
            child.mutate(mutationProbability);
            newPopulation.add(child);
        }

        population = newPopulation;
        this.globalBest = Collections.max(population, Comparator.comparingInt(individual -> individual.fitness));
        //System.out.println(this.globalBest.fitness+" "+Arrays.toString(this.globalBest.sol));
    }


    
    
}
