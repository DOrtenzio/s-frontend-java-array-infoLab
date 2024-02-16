import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random generatore = new Random();

        //Dichiarazioni Variabili e Array
        int i,n = 0; //n == lunghezza array
        boolean nonfatto = true;
        int[] numeri = new int[100];

        //Ciclo
        do {
            System.out.println("Scegli una funzione:");
            System.out.println("1 - Caricamento da tastiera;");
            System.out.println("2 - Caricamento random;");
            System.out.println("3 - Visualizzazione;");
            System.out.println("4 - Inserimento in posizione;");
            System.out.println("5 - Cancellazione di un elemento cercato;");
            System.out.println("6 - Cancellazione di tutte le occorrenze di un elemento cercato;");
            System.out.println("7 - Esci.");
            i = in.nextInt();
            in.nextLine();
            switch (i) {
                case 1: //Inserimento manuale
                    do {
                        System.out.println("Quanti elementi vuoi inserire");
                        n = in.nextInt();
                        if (n > 100 || n < 0)
                            System.out.println("Impossibile, valore massimo di numeri inseribili sono 100.");
                    } while (n>100 || n<0);
                    nonfatto = false;
                    for (int p = 0; p < n; p++) {
                        System.out.println("Valore " + (p + 1) + " :");
                        numeri[p] = in.nextInt();
                    }
                    System.out.println("\033[32m" + "Inserimento terminato!" + "\033[0m");
                    break;
                case 2: //Inserimento Casuale
                    do {
                        System.out.println("Quanti elementi vuoi inserire");
                        n = in.nextInt();
                        if (n > 100 || n < 0)
                            System.out.println("Impossibile, valore massimo di numeri inseribili sono 100.");
                    } while (n>100 || n<0);
                    nonfatto = false;
                    for (int l = 0; l < n; l++) {
                        numeri[l] = 1 + generatore.nextInt(200);
                    }
                    System.out.println("\033[32m" + "Inserimento terminato!" + "\033[0m");
                    break;
                case 3: //Visualizzazione
                    if (nonfatto == true)
                        System.out.println("\033[31m" + "Inserisci prima i valori" + "\033[0m");
                    else {
                        System.out.println("\033[33m" + "Array A:" + "\033[0m");
                        for (int l = 0; l < n; l++) {
                            System.out.print(numeri[l]+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 4: //Inserimento numero
                    if (nonfatto == true)
                        System.out.println("\033[31m" + "Inserisci prima i valori" + "\033[0m");
                    else {
                        int num, posizione;
                        System.out.println("Inserire il numero da inserire:");
                        num = in.nextInt();
                        do {
                            System.out.println("Inserire la posizione in cui inserire il numero:");
                            posizione = in.nextInt();
                            if (posizione > 100)
                                System.out.println("La posizione è inesistente");
                        } while (posizione<0 || posizione>100);
                            if (n == 100)
                                System.out.println("\033[35m" + "Attenzione " + numeri[99] + " andrà persa!" + "\033[0m");
                            for (int j = n; j >= posizione; j--) {
                                if (n == 100 && j == 100)
                                    j = n - 1;
                                numeri[j] = numeri[j - 1];
                            }
                            numeri[posizione - 1] = num;
                            if (n < posizione)
                                n += (posizione - n);
                            else
                                n++;
                    }
                    break;
                case 5: //Ricerca e cancellazione di un determinato numero
                    if (nonfatto == true)
                        System.out.println("\033[31m" + "Inserisci prima i valori" + "\033[0m");
                    else {
                        int num, posizione = 101;
                        System.out.println("Inserire il numero da cercare:");
                        num = in.nextInt();
                        for (int u = 0; u < n; u++) {
                            if (num == numeri[u]) {
                                posizione = u;
                                System.out.println("Il numero " + num + " in posizione " + (posizione+1)+" su "+ n + " : verrà cancellato.");
                                break;
                            }
                        }
                        if (posizione == 101)
                            System.out.println("\033[31m" + "Attenzione numero inesistente!" + "\033[0m");
                        else {
                            for (int j = posizione; j < n; j++) {
                                numeri[j] = numeri[j + 1];
                            }
                            n--;
                        }
                    }
                    break;
                case 6://Cancellazione di tutte le occorrenze
                    if (nonfatto == true)
                        System.out.println("\033[31m" + "Inserisci prima i valori" + "\033[0m");
                    else {
                        int num, occorrenze = 0;
                        System.out.println("Inserire il numero da cercare:");
                        num = in.nextInt();
                        for (int u = 0; u < n; u++) {
                            if (num == numeri[u]) {
                                occorrenze ++;
                            }
                        }
                        if (occorrenze == 0)
                            System.out.println("\033[31m" + "Attenzione numero inesistente!" + "\033[0m");
                        else {
                            System.out.println("Il numero " + num + " in quantità " + occorrenze + " : verrà cancellato.");
                            for (int u = 0; u < n; u++) {
                                if (num == numeri[u]) {
                                    for (int j = u; j < n; j++) {
                                        numeri[j] = numeri[j + 1];
                                    }
                                }
                            }
                            n-=occorrenze;
                        }
                    }
                    break;
                case 7: //Addiì
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("\033[31m" +"Scegli una selezione proposta"+"\033[0m");
            }
        } while (i != 7);
    }
}