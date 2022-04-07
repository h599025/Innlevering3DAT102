package no.hvl.dat102.oving6;

import java.util.*;

public class Oppg1b {

    public static void main(String[] args) {
        Integer tabell[] = new Integer[50_000]; // Gammel mac, så tar over 5sek
        fylleTabellToElement(tabell);

        double start = System.nanoTime();
        sorteringVedInssettingToEl(tabell, 0, tabell.length-1);
        double slutt = System.nanoTime();
        double tidSek = (slutt - start) / 1_000_000_000;

        System.out.println(String.format("%.2f", tidSek) + " sekunder");

        // Utskrift for å sjekke at tabellen er sortert
        //for(int i = 0; i < tabell.length; i++) {
        //    System.out.print(tabell[i] + " ");
        //}
    }

    public static <T extends Comparable<? super T>> void sorteringVedInssettingToEl(T[] tabell, int start, int slutt) {

        for (int i = start + 1; i <= slutt-1; i+=2) {
            T temp = tabell[i];
            T temp2 = tabell[i+1];
            int j = i - 1;

            if(temp.compareTo(temp2) > 0) {
                temp = tabell[i+1];
                temp2 = tabell[i];
            }

            boolean ferdig = false;
            while (j >= 0) {
                if (temp2.compareTo(tabell[j]) < 0) {
                    tabell[j + 2] = tabell[j];
                    j--;
                } else {
                    break;
                }
            }
            tabell[j+2] = temp2;

            while (j >= 0) {
                if (temp.compareTo(tabell[j]) < 0) {
                    tabell[j + 1] = tabell[j];
                    j--;
                } else {
                    break;
                }
            }
            tabell[j+1] = temp;
        }

    }

    public static void fylleTabellToElement(Integer[] tabell) {
        Random random = new Random();

        for(int i = 0; i<tabell.length; i++) {
            tabell[i] = random.nextInt(101);
        }
    }
}
