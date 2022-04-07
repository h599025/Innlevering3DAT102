package no.hvl.dat102.oving6;

import java.util.*;

public class Oppg1 {

    public static void main(String[] args) {
        Integer tabell[] = new Integer[50_000]; // Gammel mac, så tar over 5sek
        fylleTabell(tabell);

        double start = System.nanoTime();
        sorteringVedInssetting(tabell, 0, tabell.length-1);
        double slutt = System.nanoTime();
        double tidSek = (slutt - start) / 1_000_000_000;

        System.out.println(String.format("%.2f", tidSek) + " sekunder");

        // Utskrift for å sjekke at tabellen er sortert
        //for(int i = 0; i < tabell.length; i++) {
        //    System.out.print(tabell[i] + " ");
        //}
    }

    public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
        // Bytte minste element til første pos
        int p = 0;
        for(int i = 0; i<a.length; i++) {
            if(a[p].compareTo(a[i]) > 0) {
                p = i;
            }

            // Setter riktig element først i tabellen
            T temp = a[i];
            a[i] = a[p];
            a[p] = temp;
        }

        for (int i = start + 1; i <= slutt; i++) {
            T temp = a[i];
            int j = i - 1;
            //boolean ferdig = false;
            while (j >= 0) { // fjernet !ferdig
                if (temp.compareTo(a[j]) < 0) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    break;    // fjernet ferdig = true
                }
            }
            a[j+1] = temp;
        }

    }


    public static void fylleTabell(Integer[] tabell) {
        Random random = new Random();

        for(int i = 0; i<tabell.length; i++) {
            // Begrenser verdiene til mellom 0 og 100
            tabell[i] = random.nextInt(101);
        }
    }
}

