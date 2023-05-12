/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import javax.swing.UIManager;

/**
 *
 * @author amir
 */
public class WDPEcom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WDPEcom a = new WDPEcom();
        a.rungui();
    }
    public void rungui(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        OfferGUI offerGUI = new OfferGUI();
        offerGUI.setVisible(true);
    }
    
    
}
