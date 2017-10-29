/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvinkopdracht3;

/**
 * Paard class
 * 
 * @author Martijn van der Bruggen
 * @version alpha release
 * (c) Hogeschool van Arnhem en Nijmegen
 *
 * Dit bestand niet aanpassen. Aanroepen vanuit Race
 *
 * 
 */

import java.util.Random;
import java.awt.*;
import javax.swing.ImageIcon;

public class Paard {

    private int afstand, paardNummer;
    private static int aantal = 0;
    private String naam;
    private Color kleur;
    public ImageIcon plaatje;
    Random random = new Random();

    /* Constructor voor Paard */
    Paard(String name, Color kl, ImageIcon icon) {
        this.naam = name;
        this.kleur = kl;
        this.afstand = 0;
        this.plaatje = icon;
        paardNummer = ++aantal;
    }

    Paard(String string, Color blue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNaam() {
        return this.naam;
    }

    public int getAfstand() {
        return this.afstand;
    }

    public int getPaardNummer() {
        return paardNummer;
    }

    public Color getKleur() {
        return kleur;
    }
    
    public ImageIcon getAfbeelding() {
        return plaatje;
    }
        public void run() {
        afstand = afstand + random.nextInt(11);
        System.out.println(naam + " is op positie " + afstand);
    }
}
