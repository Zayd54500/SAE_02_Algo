import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe permettant de lire les fichiers du réseau STAN
 * et de construire un graphe à partir de ces données
 */
public class LireReseau {

    /**
     * Lit les fichiers de stations et de connexions et construit un graphe
     * @param fichierStations chemin vers le fichier des arrêts (stan.nodes.txt)
     * @param fichierConnexions chemin vers le fichier des connexions (stan.edges.txt)
     * @return le graphe construit
     */
    public static Graphe lire(String fichierStations, String fichierConnexions) {
        GrapheListe graphe = new GrapheListe();

        // Lecture des connexions
        try (BufferedReader br = new BufferedReader(new FileReader(fichierConnexions))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parties = ligne.split(";");
                String depart = parties[0];
                String destination = parties[1];
                double cout = Double.parseDouble(parties[2]);

                // Bidirectionnel : on ajoute les deux sens
                graphe.ajouterArc(depart, destination, cout);
                graphe.ajouterArc(destination, depart, cout);
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture connexions : " + e.getMessage());
        }

        return graphe;
    }
}