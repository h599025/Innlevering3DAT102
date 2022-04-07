package no.hvl.dat102.oving6;

import java.util.Random;

public class Oppg2 {

    public static void main(String[] args) {

        Random tilfeldig = new Random();
        int n = 64000;
        int antal = 10;
        Integer p = 10;

        Integer[][] a = new Integer[antal][n];
        Integer[] b = new Integer[n];

        // set inn tilfeldige heiltal i alle rekker
        for (int i = 0; i < antal; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = tilfeldig.nextInt();
            }
        }

        // Hører til oppg 2b
        for(int i = 0; i<n; i++) {
            //b[i] = p;
            b[i] = tilfeldig.nextInt();
        }

        double start = System.nanoTime();

        for (int i = 0; i < antal; i++) {
             quickSort(a[i], 0, a[i].length - 1); // For å kjøre oppg 2b, bytt a[i] til b på begge plasser
            // insertionSort(a[i]);
            // selectionSort(a[i]);
            // mergeSort(a[i], 0, a[i].length-1);
        }
        double slutt = System.nanoTime();
        double tidSek = (slutt - start) / 1_000_000_000;

        // Utskrift av tid for hvert forsøk
        System.out.println(String.format("%.2f", tidSek) + " sekunder");

        // Utskrift for tabell med målte verdier
        //System.out.printf("Resultat\n" + "n\t" + "Antall målinger\t" + "Målt tid(gjennomsnitt)\t" + "Teoretisk tid c*f(n)\3n" +
        //                                "32 000\t" + "");

        // Utskrift for å sjekke at tabellen er sortert
        //for(int i = 0; i < tabell.length; i++) {
        //    System.out.print(tabell[i] + " ");
        //}
    }


    // QuickSort
    public static <T extends Comparable<T>> void quickSort(T[] tabell, int min, int max) {
        if((max - min+1)>= 20) {
            int piv = finnPartisjon(tabell, min, max);

            quickSort(tabell, min, piv - 1);
            quickSort(tabell, piv + 1, max);
        } else {
            insertionSort(tabell);
        }
    }

    public static <T extends Comparable<T>> int finnPartisjon(T[] tabell, int min, int max) {
        T temp, p;
        int midten = (min + max) / 2;
        p = tabell[midten];
        swap(tabell, midten, min);

        int venstre = min + 1;
        int hoyre = max-2;
        while (venstre < hoyre) {

            while (venstre < hoyre && tabell[venstre].compareTo(p) < 0) {
                venstre++;
            }
            while (tabell[hoyre].compareTo(p) > 0) {
                hoyre--;
            }
            if (venstre < hoyre) {
                swap(tabell, venstre, hoyre);
                venstre++;
                hoyre--;
            }
        }
        swap(tabell, min, hoyre);
        return hoyre;
    }

    private static <T> void swap(T[] tabell, int i, int j) {
        T temp = tabell[i];
        tabell[i] = tabell[j];
        tabell[j] = temp;
    }


    // insertionSort
    public static <T extends Comparable<T>> void insertionSort(T[] tabell) {
        for(int i = 1; i < tabell.length; i++) {
            T el = tabell[i];
            int bytteVerdi = i-1;

            // while(bytteVerdi >= 0 && tabell[bytteVerdi] > el) {
            while(bytteVerdi >= 0 && el.compareTo(tabell[bytteVerdi]) < 0) {
                tabell[bytteVerdi+1] = tabell[bytteVerdi];
                bytteVerdi = bytteVerdi - 1; // bytteVerdi--;
            }
            tabell[bytteVerdi+1] = el;
        }
    }


    // Selection sort
    public static <T extends Comparable<T>> void selectionSort(T[] tabell) {
        int min;

        for(int i = 0; i < tabell.length-1; i++) {
            min = i;
            for(int j = i+1; j < tabell.length; j++) {
                if(tabell[j].compareTo(tabell[min]) < 0) {
                    min = j;
                }
            }

            if(min != i) {
                T temp = tabell[i];
                tabell[i] = tabell[min];
                tabell[min] = temp;
            }
        }
    }


    // Merge sort
    public static <T extends Comparable<T>> void mergeSort(T[] tabell, int forste, int siste) {
        if(forste >= siste) {

        } else {
            int midten = (forste + siste) / 2;
            mergeSort(tabell, forste, midten);
            mergeSort(tabell, midten+1, siste);
            merge(tabell, forste, midten, siste);
        }

    }

    public static <T extends Comparable<T>> void merge(T[] tabell, int forste, int midten, int siste) {
        int storrelse = siste - forste + 1;
        T[] hjelpeTabell = (T[])(new Comparable[storrelse]);

        int forsteV = forste;
        int sisteV = midten;
        int forsteH = midten+1;
        int sisteH = siste;

        int i = 0;

        while((forsteV <= sisteV) && (forsteH <= sisteH)) {
            if(tabell[forsteV].compareTo(tabell[forsteH])<= 0) {
                hjelpeTabell[i] = tabell[forsteV];
                forsteV++;
            } else {
                hjelpeTabell[i] = tabell[forsteH];
                forsteH++;
            }
            i++;
        }

        while(forsteV <= sisteV){
            hjelpeTabell[i] = tabell[forsteV];
            forsteV++;
            i++;
        }

        while(forsteH <= sisteH) {
            hjelpeTabell[i] = tabell[forsteH];
            forsteH++;
            i++;
        }

        int h = 0;
        for(i = forste; i <= siste; i++) {
            tabell[i] = hjelpeTabell[h];
            h++;
        }
    }
}
