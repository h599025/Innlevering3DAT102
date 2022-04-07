package no.hvl.dat102.Oppgave4;

import java.util.*;

public class main {

    public static void main(String[] args) {
/*
//      Oppgave 4a
        System.out.println("Oppgave 4a");
        for (int i = 0; i < 5; i++) {
            BS_Tre tre = new BS_Tre<>(Math.random());
            for (int j = 0; j < 1023; j++) {
                tre.leggTil(Math.random());
            }

            System.out.println("Høgden er " + tre.height());
        }

        System.out.println();


//      Oppgave 4b
        System.out.println("Oppgave 4b");
        int totalHoyde = 0;
        int antNoder = 0;
        int minHøgde = 0;
        int maksHøgde = 0;

        BS_Tre tre1 = new BS_Tre<>();
        for(int i = 0; i < 100; i++) {
        	tre1 = new BS_Tre<>(Math.random());

        	for(int j = 0; j < 1023; j++) {
        		tre1.leggTil(Math.random());
        		antNoder++;
        	}
        	totalHoyde += tre1.height();

        	if(maksHøgde == 0 && minHøgde == 0) {
        		maksHøgde = tre1.height();
        		minHøgde = tre1.height();
        	} else if(maksHøgde < tre1.height()) {
        		maksHøgde = tre1.height();
        	} else if(minHøgde > tre1.height()) {
        		minHøgde = tre1.height();
        	}
        }

        int gjennomsnitt = totalHoyde / 100;

//      Antar at dåke er ute etter antall noder totalt i Oppg 4b i)
        System.out.println("Totalt antall noder: " + antNoder);
        System.out.println("Minimal teoretisk høgde for n noder er: " + tre1.heightComplete(1023));
        System.out.println("Maksimal teoretisk høgde er n, som er lik 1023");
        System.out.println("Største målte høgde: " + maksHøgde);
        System.out.println("Minste målte høgde: " + minHøgde);
        System.out.println("Gjennomsnittlig høgde er " + gjennomsnitt);

        System.out.println(); */


//      Oppgave 4c
        System.out.println("Oppgave 4c");
        int totalHoydeC = 0;

        for(int i = 0; i < 100; i++) {
            BS_Tre tre2 = new BS_Tre<>(Math.random());

            for(int j = 0; j < 8191; j++) {
                tre2.leggTil(Math.random());
            }
            totalHoydeC += tre2.height();

        }

        int gjennomsnittC = totalHoydeC / 100;

        System.out.println("Gjennomsnittlig høgde er " + gjennomsnittC);
    }
}
