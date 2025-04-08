import java.util.ArrayList;
import java.util.Scanner;

public class GestionePlayer implements Media {
    private ArrayList<Canzone> canzoni;
    private ArrayList<Video> video;

    public GestionePlayer() {
        this.canzoni = new ArrayList<>();
        this.video = new ArrayList<>();
    }

    @Override
    public void play(Scanner scanner) {

        // Prompt the user to enter the title
        System.out.println("Inserisci il titolo dell'elemento da riprodurre:");
        String titolo = scanner.nextLine();

        // Stop any currently playing item
        for (Canzone canzone : canzoni) {
            if (canzone.getRiproduzione()) {
                canzone.cambiaRiproduzione();
            }
        }
        for (Video video : video) {
            if (video.getRiproduzione()) {
                video.cambiaRiproduzione();
            }
        }

        // Search for the song
        for (Canzone canzone : canzoni) {
            if (canzone.getTitolo().equalsIgnoreCase(titolo)) {
                canzone.cambiaRiproduzione();
                System.out.println("In riproduzione: Canzone - " + canzone);
                return;
            }
        }

        // Search for the video
        for (Video video : this.video) {
            if (video.getTitolo().equalsIgnoreCase(titolo)) {
                video.cambiaRiproduzione();
                System.out.println("In riproduzione: Video - " + video);
                return;
            }
        }

        // If no item is found
        System.out.println("Elemento non trovato nella playlist.");
    }

    @Override
    public void stop(Scanner scanner) {
        // Prompt the user to enter the title
        System.out.println("Inserisci il titolo dell'elemento da fermare:");
        String titolo = scanner.nextLine();

        // Search for the song
        for (Canzone canzone : canzoni) {
            if (canzone.getTitolo().equalsIgnoreCase(titolo)) {
                if (canzone.getRiproduzione()) {
                    canzone.cambiaRiproduzione();
                    System.out.println("Riproduzione fermata: Canzone - " + canzone);
                } else {
                    System.out.println("La canzone non è in riproduzione.");
                }
                return;
            }
        }

        // Search for the video
        for (Video video : this.video) {
            if (video.getTitolo().equalsIgnoreCase(titolo)) {
                if (video.getRiproduzione()) {
                    video.cambiaRiproduzione();
                    System.out.println("Riproduzione fermata: Video - " + video);
                } else {
                    System.out.println("Il video non è in riproduzione.");
                }
                return;
            }
        }

        // If no item is found
        System.out.println("Elemento non trovato nella playlist.");
    }

    @Override
    public void pausa() {

    }

    @Override
    public void getTitolo() {

    }

    public void aggiungiCanzone(Scanner sc) {

        System.out.println("Inserisci il titolo della canzone:");
        String titolo = sc.nextLine();

        System.out.println("Inserisci l'artista della canzone:");
        String artista = sc.nextLine();

        Canzone nuovaCanzone = new Canzone(titolo, artista);
        this.canzoni.add(nuovaCanzone);

        System.out.println("Canzone aggiunta con successo: " + nuovaCanzone);
    }

    public void aggiungiVideo(Scanner scanner) {

        System.out.println("Inserisci il titolo del video:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la durata del video (in secondi):");
        int durata = 0;
        try {
            durata = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Durata non valida. Impostata a 0.");
        }

        Video nuovoVideo = new Video(titolo, durata);
        this.video.add(nuovoVideo);

        System.out.println("Canzone aggiunta con successo: " + nuovoVideo);
    }

    public void rimuoviCanzone(Scanner sc) {
        System.out.println("Inserisci il titolo della canzone:");
        String titolo = sc.nextLine();

        System.out.println("Inserisci l'artista della canzone:");
        String artista = sc.nextLine();

        Canzone RimuoviCanzone = new Canzone(titolo, artista);
        this.canzoni.add(RimuoviCanzone);

        System.out.println("Canzone rimossa con successo: " + RimuoviCanzone);
    }

    public void rimuoviVideo(Scanner scanner) {


        System.out.println("Inserisci il titolo del video da rimuovere:");
        String titolo = scanner.nextLine();

        boolean trovato = false;
        for (int i = 0; i < video.size(); i++) {
            if (video.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                video.remove(i);
                trovato = true;
                System.out.println("Video rimosso con successo.");
                break;
            }
        }

        if (!trovato) {
            System.out.println("Video non trovato nella playlist.");
        }
    }

    public ArrayList<Canzone> visualizzaPlaylist() {
        return canzoni;

        /* DEVE:
         * - aggiungere una canzone
         * - aggiungere un video
         * - visualizzare playlist
         * - riprodurre un elemento
         * - rimuovere un elemento */

        /* nei metodi play, stop, pausa, ecc.
         * ritorno una stringa con lo stato del player
         * (in riproduzione, in pausa ecc.) */
    }

    @Override
    public String toString() {
        return "";
    }
}

