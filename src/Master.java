
import jade.core.AID;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amir
 */
public class Master extends Agent {
    
    public static int numberOfRunning=0;
    public static Solution best=new Solution();
    public void setup(){
        
       System.out.println("i'm:"+getAID().getLocalName());
       jade.core.Runtime r= jade.core.Runtime.instance();
        Profile p2 = new ProfileImpl();
        ContainerController cc = r.createAgentContainer(p2);
        try{
            for (int i = 0;i<10;i++){
                AgentController a = cc.createNewAgent("pop"+i, "Population", null);
                a.start();
                numberOfRunning++;
            }
            
        }catch (Exception  e){
            e.printStackTrace();
        }
        addBehaviour(new MasterBehaviour());
    }
    private class MasterBehaviour extends CyclicBehaviour {
        public void action() {
            ACLMessage msg = receive();
            
            if (msg != null) { 
                numberOfRunning--;
                Solution temp;
                try {
                    temp = (Solution)msg.getContentObject();
                    if (temp.fitness>best.fitness){
                    best = temp;
                }
                } catch (UnreadableException ex) {
                    Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(numberOfRunning==0){  
                    best.print();
                    
                }    
            } else { 
                block(); 
            }
        }
    }
    
}
