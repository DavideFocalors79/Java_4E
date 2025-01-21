import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Creazione dei piloti
            Pilota p1 = new Pilota("Mario", "Rossi", "Italia", 30);
            Pilota p2 = new Pilota("Luigi", "Verdi", "Italia", 28);
            Pilota p3 = new Pilota("Giovanni", "Bianchi", "Italia", 32);

            // Creazione delle auto
            Auto a1 = new Auto("Ferrari", p1, 3000);
            Auto a2 = new Auto("Mercedes", p2, 3500);
            Auto a3 = new Auto("Red Bull", p3, 4000);

            // Creazione della gara e aggiunta delle auto
            Gara gara = new Gara("Gran Premio di Monza");
            gara.aggiungiAuto(a1);
            gara.aggiungiAuto(a2);
            gara.aggiungiAuto(a3);

            // Stampa della griglia di partenza
            System.out.println(gara.toString());

            // Salvataggio della griglia di partenza in formato JSON
            salvaGrigliaInJson(gara);

            // Salvataggio della griglia di partenza in formato CSV
            salvaGrigliaInCsv(gara);

            // Esecuzione della gara
            gara.corriGara();
            System.out.println("Vincitore della gara: " + gara.getVincitore().toString());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // Metodo per salvare la griglia di partenza in formato JSON
    private static void salvaGrigliaInJson(Gara gara) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Auto> griglia = gara.getAutoInGara(); // Otteniamo la lista delle auto

        // Serializza la lista delle auto in formato JSON
        String jsonContent = gson.toJson(griglia);

        try {
            Files.write(Path.of("griglia.json"), jsonContent.getBytes());
            System.out.println("Griglia salvata in griglia.json");
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio del file JSON: " + e.getMessage());
        }
    }

    // Metodo per salvare la griglia di partenza in formato CSV
    private static void salvaGrigliaInCsv(Gara gara) {
        List<Auto> griglia=gara.getAutoInGara(); // Otteniamo la lista delle auto
        StringBuilder csvContent = new StringBuilder();

        // Aggiungiamo l'intestazione del CSV
        csvContent.append("Scuderia, Pilota, Nazione, Età, Cilindrata\n");

        // Aggiungiamo i dati delle auto
        for (Auto auto : griglia) {
            Pilota pilota = auto.getPilota();
            csvContent.append(auto.getScuderia())
                    .append(", ")
                    .append(pilota.getNome())
                    .append(" ")
                    .append(pilota.getCognome())
                    .append(", ")
                    .append(pilota.getNazionalita())
                    .append(", ")
                    .append(pilota.getEta())
                    .append(", ")
                    .append(auto.getCilindrata())
                    .append("\n");
        }

        // Scriviamo il contenuto nel file CSV
        try {
            Files.write(Path.of("griglia.csv"), csvContent.toString().getBytes());
            System.out.println("Griglia salvata in griglia.csv");
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio del file CSV: " + e.getMessage());
        }
    }
}
