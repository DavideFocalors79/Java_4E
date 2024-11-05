import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;


import frontScreen.FrontEnd;
import mensola.*;

import static frontScreen.FrontEnd.*;
import static Tools.utility.*;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Libro> mensola = new ArrayList<>();
        final int MAX = 3;
        Libro[] libri = new Libro[MAX];
        int nLibri = 0;
        boolean fine = true;
        String[] opzioni = {"MENSOLA", "Inserimento", "visualizza", "inserimento2","rimozione elmento oggetto","rimozione elemento indice","Visualizzazione Succ/Prec","Modifica pagine","Aggiungi Automaticamente", "fine"};

        do {
            switch (menu(opzioni, keyboard)) {
                case 1: {
                    Libro libro = leggiLibro(keyboard);
                    try {


                        int k = indexList(mensola, libro);
                        System.out.println("Il libro si trova nella posizione:\n" + k);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        mensola.add(libro);
                    }
                    break;
                }
                case 2:{
                    mensola.forEach(x -> System.out.println(x.toString()));
                    break;
                }
                case 3:{
                    try {
                        if (mensola.size() < MAX) {
                            Libro libro = leggiLibro(keyboard);

                            if(mensola.indexOf(libro)==-1){
                                mensola.add(libro);
                            }
                            else
                                throw new Exception("Libro presente");

                        }else
                            throw new Exception("Mensola Piena");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4:
                    Libro libro = leggiLibro(keyboard, true);
                    try{
                        if(!mensola.contains(libro))
                            throw new Exception("Libro non trovato");

                        mensola.remove(libro);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    int pos = Index(keyboard);
                    try{
                        if(!mensola.contains(mensola.get(pos)))
                            throw new Exception("Libro non trovato");
                        mensola.remove(pos);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    VisuallizaIndex(keyboard,mensola);
                break;

                case 7:
                    try{
                        modificaPagina(mensola, keyboard);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    assegnaLibriAutomaticamente(mensola);
                    break;
                default:
                    fine = false;
            }

        } while (fine);
    }

    private static int indexList(ArrayList<Libro> mensola, Libro libro) throws Exception {
        for (int i = 0; i < mensola.size(); i++) {
            if (mensola.get(i).autore.equals(libro.autore) && mensola.get(i).titolo.equals(libro.titolo)) {
                return i;

            }
        }
        throw new Exception("Libro non esistente");

    }
    private static void modificaPagina(ArrayList<Libro> mensola, Scanner keyboard)throws Exception{
        Libro libroInput = leggiLibro(keyboard, true);
        if(!mensola.contains(libroInput))
            throw new Exception("Libro non trovato");

        /* inserimento nuova pagina */
        int numPagine=0;
        boolean check;

        do{
            check = false;
            try {
                System.out.println("Inserisci il numero delle pagine");
                numPagine = Integer.parseInt(keyboard.nextLine());
                if(numPagine<=0)
                    throw new Exception("Valore negativo inserito non valido");
            }catch(NumberFormatException e){
                System.out.println("Formato del valore inserito non valido");
                check = true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        mensola.get(mensola.indexOf(libroInput)).numeroPagine = numPagine;
    }


    public static void assegnaLibriAutomaticamente(ArrayList<Libro> mensola){
        String[] listaNomi = {"Dante", "Catullo", "Leopardi", "Boccaccio", "Petrarca"};
        String[] listaTitoli = {"Divina Commedia", "Ciao", "Canti", "Decameron", "Canzoniere"};

        for(int i=0;i<5;i++) {
            Libro libroInserito = new Libro();
            libroInserito.numeroPagine = 5;
            libroInserito.dataPubblicazione = LocalDate.of(2024,12,11);
            libroInserito.tipologia = Genere.MANUALE;
            libroInserito.prezzoLibro = 15;
            libroInserito.titolo = listaTitoli[i];
            libroInserito.autore = listaNomi[i];
            mensola.add(libroInserito);
        }
    }
}
