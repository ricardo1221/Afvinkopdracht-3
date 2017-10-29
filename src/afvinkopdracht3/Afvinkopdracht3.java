/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvinkopdracht3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Afvinkopdracht3 extends JFrame implements ActionListener {

    /** declaratie van variabelen */
    /* (1) Declareer hier een constante int met de naam lengte en een waarde van 250 */
    static int lengte = (250);
    /* (2) Declareer hier h1, h2, h3, h4 van het type Paard
     *  Deze paarden instantieer je later in het programma
     */
    Paard h1;
    Paard h2;
    Paard h3;
    Paard h4;

    /* (3) Declareer een button met de naam button van het type JButton */
    private JButton button;
    private JPanel panel;

    /** Applicatie - main functie voor runnen applicatie */
    public static void main(String[] args) {
        Afvinkopdracht3 frame = new Afvinkopdracht3();
        frame.setSize(400,200);
        /* (4) Geef het frame een breedte van 400 en hoogte van 140 */
        frame.createGUI();
        frame.setVisible(true);
    }

    /** Loop de race
     */
    private void startRace(Graphics g) {
        panel.setBackground(Color.white);
        /** Tekenen van de finish streep */
        /* (5) Geef de finish streep een rode kleur */
        g.setColor(Color.red);
        g.fillRect(lengte+10, 0, 3, 140);
        /**(6) Creatie van 4 paarden
         * Dit is een instantiering van de 4 paard objecten
         * Bij de instantiering geef je de paarden een naam en een kleur mee
         * Kijk in de class Paard hoe je de paarden
         * kunt initialiseren.
         */
        h1 = new Paard("1",Color.green, new ImageIcon("C:\\Users\\ricar\\Desktop\\feelsbadman.jpeg"));
        h2 = new Paard("2",Color.yellow, new ImageIcon("C:\\Users\\ricar\\Desktop\\feelsbadman.jpeg"));
        h3 = new Paard("3",Color.red, new ImageIcon("C:\\Users\\ricar\\Desktop\\feelsbadman.jpeg"));
        h4 = new Paard("4",Color.blue, new ImageIcon("C:\\Users\\ricar\\Desktop\\feelsbadman.jpeg"));
      
        /** Loop tot een paard over de finish is*/
        while (h1.getAfstand() < lengte
                && h2.getAfstand() < lengte
                && h3.getAfstand() < lengte
                && h4.getAfstand() < lengte)
                {
            h1.run();
            h2.run();
            h3.run();
            h4.run();
           

            /* (7) Voeg hier een aanroep van de methode pauzeer toe zodanig
             * dat er 1 seconde pauze is. De methode pauzeer is onderdeel
             * van deze class
             */
            pauzeer(250);
            /* (8) Voeg hier code in om 4 paarden te tekenen die rennen
             * Dus een call van de methode tekenPaard
             */
            tekenPaard(g,h1);
            tekenPaard(g,h2);
            tekenPaard(g,h3);
            tekenPaard(g,h4);
       
//       
        }
        /** Kijk welk paard gewonnen heeft
         */
        if (h1.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h1.getNaam() + " heeft gewonnen!");
        }
        if (h2.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h2.getNaam() + " heeft gewonnen!");
        }
        if (h3.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h3.getNaam() + " heeft gewonnen!");
        }
        if (h4.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h4.getNaam() + " heeft gewonnen!");
        }
    }

    /** Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 140));
        panel.setBackground(Color.white);
        window.add(panel);
        /* (9) Zet hier de tekst Run! op de button */
        button =new JButton();
        button.setText("Ren!");
        window.add(button);
        button.addActionListener(this);
    }

    /** Teken het paard */
    private void tekenPaard(Graphics g, Paard h) {
        g.setColor(h.getKleur());
        
        g.fillRect(10, 20 * h.getPaardNummer(), h.getAfstand() , 5);
    }
    
    private void tekenPlaatje(Graphics g, Paard h) {
        ImageIcon icoon = h.getAfbeelding();
        Image icon = icoon.getImage();
        g.drawImage(icon, 10, 20, this);
    }

    /** Actie indien de button geklikt is*/
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        /* (10) Roep hier de methode startrace aan met de juiste parameterisering */
        
        startRace (paper);
    }

    /** Pauzeer gedurende x millisecondes*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("interuptie");
        }
    }
    
    
}
