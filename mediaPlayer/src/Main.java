import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.Tools.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionePlayer gestionePlayer = new GestionePlayer();
        String opzioni[] = {"Menu","1. Aggiungi canzone", "2. Aggiungi video", "3. Visualizza playlist", "4. Riproduzione", "5. Rimuovi Video","6. Rimuovi canzone", "7. Esci"};
        String opzioniRiproduzione[] = {"Menu","1. Play", "2. Stop", "3. Pausa","6. Esci"};

        while (true) {
            switch (Menu(opzioni, sc)) {
                case 1:
                    ((GestionePlayer) gestionePlayer).aggiungiCanzone(sc);
                    break;
                case 2:
                    ((GestionePlayer) gestionePlayer).aggiungiVideo(sc);
                    break;
                case 3:
                    System.out.println(((GestionePlayer) gestionePlayer).visualizzaPlaylist());
                    break;
                case 4:
                    while (true) {
                        switch (Menu(opzioniRiproduzione, sc)) {
                            case 1:
                                gestionePlayer.play(sc);
                                break;
                            case 2:
                                gestionePlayer.stop(sc);
                                break;
                            case 3:
                                gestionePlayer.pausa();
                                break;
                            case 4:
                                System.out.println("Uscita dal menu di riproduzione...");
                                return; // Exit the nested menu
                            default:
                                System.out.println("Opzione non valida");
                                break;
                        }
                    }
                case 5:
                    ((GestionePlayer) gestionePlayer).rimuoviVideo(sc);
                    break;
                case 6:
                    ((GestionePlayer) gestionePlayer).rimuoviCanzone(sc);
                    break;
                case 7:
                    System.out.println("Uscita dal programma...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opzione non valida");
            }
        }


    }
}
