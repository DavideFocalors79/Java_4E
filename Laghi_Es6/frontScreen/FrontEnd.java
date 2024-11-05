package frontScreen;

import mensola.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Tools.utility;
import java.util.ArrayList;

import static Tools.utility.menu;

public class FrontEnd {
    public static Libro leggiLibro(Scanner scanner) {
        Libro output = new Libro();

        System.out.println("inserire l'autore: ");
        output.autore = scanner.next();

        System.out.println("Inserire titolo: ");
        output.titolo = scanner.next();

        System.out.println("Numero di pagine: ");
        output.numeroPagine = Integer.parseInt(scanner.next());

        output.prezzoLibro = output.costoPerPagina * output.numeroPagine;

        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Generi";
        for (int i = 0; i < generi.length; i++) {
            menuData[i + 1] = generi[i].toString();
        }
        int genereIndex;
        do {
            genereIndex = utility.menu(menuData, scanner) - 1;
        } while (genereIndex == -1);
        output.tipologia = generi[genereIndex];

        while (true) {
            try {
                System.out.println("Inserisci la data di pubblicazione (dd-mm-yyyy): ");
                String dateInput = scanner.next();
                output.dataPubblicazione = LocalDate.parse(dateInput, output.formattazioneData);

                break;
            } catch (Exception e) {
                System.out.println("\t<ATTENZIONE> Valore data invalido.\n\tInserire una dato con formattazione specificata tra parentesi.");
            }
        }

        return output;
    }

    public static Libro leggiLibro(Scanner scanner, boolean soloAutoreTitolo){
        Libro output = new Libro();

        System.out.println("inserire l'autore: ");
        output.autore = scanner.next();

        System.out.println("Inserire titolo: ");
        output.titolo = scanner.next();

        if(soloAutoreTitolo)
            return output;

        System.out.println("Numero di pagine: ");
        output.numeroPagine = Integer.parseInt(scanner.next());

        output.prezzoLibro = output.costoPerPagina * output.numeroPagine;

        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Generi";
        for (int i = 0; i < generi.length; i++) {
            menuData[i + 1] = generi[i].toString();
        }
        int genereIndex;
        do {
            genereIndex = utility.menu(menuData, scanner) - 1;
        } while (genereIndex == -1);
        output.tipologia = generi[genereIndex];

        while (true) {
            try {
                System.out.println("Inserisci la data di pubblicazione (dd-mm-yyyy): ");
                String dateInput = scanner.next();
                output.dataPubblicazione = LocalDate.parse(dateInput, output.formattazioneData);

                break;
            } catch (Exception e) {
                System.out.println("\t<ATTENZIONE> Valore data invalido.\n\tInserire una dato con formattazione specificata tra parentesi.");
            }
        }

        return output;
    }

    public static void visualizza(int contatore, Libro[] mensola) {
        for (int i = 0; i < contatore; i++) {
            System.out.println("AUTORE: " + mensola[i].autore +
                    "\nTITOLO: " + mensola[i].titolo +
                    "\nN° PAGINE: " + mensola[i].numeroPagine +
                    "\nTIPOLOGIA: " + mensola[i].tipologia + "\n");
        }
    }

    public static int Index(Scanner scanner){
        int pos;
        while (true) {
            try {
                System.out.println("Inserisci Indice Libro");
                pos = scanner.nextInt();

                break;
            } catch (Exception e) {
                System.out.println("Valore non valido");
            }
        }

        return pos;
    }

    public static void VisuallizaIndex(Scanner scanner, ArrayList<Libro> mensola){

        int pos = Index(scanner);

        String[] opzioni = {"Visualizzazione","Precedenti","Successivi","Fine"};

        boolean fine=true;
        try {
            do{
                switch (menu(opzioni, scanner)) {

                    case 1:
                        if(pos>0) {
                            pos--;
                            System.out.println(mensola.get(pos).toString());
                        }else{
                            System.out.println("Valore non valido");
                        }
                        break;
                    case 2:
                        if(pos < mensola.size()-1) {
                            pos++;
                            System.out.println(mensola.get(pos).toString());
                        }else{
                            System.out.println("Valore non valido");
                        }
                        break;

                    default:
                        fine=false;
                        break;
                    }
            }while(fine==true);
        } catch (Exception e) {
        System.out.println("Valore non valido");
        }
    }
}