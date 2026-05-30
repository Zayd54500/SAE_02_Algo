import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe principale du programme.
 * Elle sert à lancer les algorithmes de plus court chemin depuis le terminal
 * ou depuis l'interface graphique Python.
 */
public class Principal {

    /**
     * Point d'entrée du programme.
     *
     * @param args args[0] = noeud de départ, args[1] = noeud d'arrivée
     */
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Erreur : il faut donner un départ et une arrivée.");
            System.out.println("Exemple : java -jar Projet.jar \"A\" \"C\"");
            return;
        }

        String depart = args[0];
        String arrivee = args[1];

        GrapheListe graphe = new GrapheListe();

        chargerGrapheDepuisFichier(graphe, "stan.edges.txt");

        Dijkstra dijkstra = new Dijkstra();

        long debutDijkstra = System.nanoTime();
        Valeurs resultatDijkstra = dijkstra.resoudre(graphe, depart);
        long finDijkstra = System.nanoTime();

        BellmanFord bellmanFord = new BellmanFord();

        long debutBellman = System.nanoTime();
        Valeurs resultatBellman = bellmanFord.calculer(graphe, depart);
        long finBellman = System.nanoTime();

        enregistrerTemps("Dijkstra", finDijkstra - debutDijkstra);
        enregistrerTemps("Bellman-Ford", finBellman - debutBellman);

        ArrayList<String> chemin = resultatDijkstra.calculer(arrivee);

        if (chemin.isEmpty()) {
            System.out.println("Aucun chemin trouvé entre " + depart + " et " + arrivee);
        } else {
            System.out.println("Chemin le plus court :");
            System.out.println(chemin);
            System.out.println("Distance : " + resultatDijkstra.getValeur(arrivee));
        }
    }

    /**
     * Charge un graphe depuis un fichier texte d'arcs.
     * Format attendu : depart;destination;cout
     *
     * @param graphe le graphe à remplir
     * @param nomFichier le nom du fichier contenant les arcs
     */
    public static void chargerGrapheDepuisFichier(GrapheListe graphe, String nomFichier) {
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
            String ligne;

            while ((ligne = lecteur.readLine()) != null) {
                ligne = ligne.trim();

                if (ligne.isEmpty()) {
                    continue;
                }

                String[] morceaux = ligne.split(";");

                if (morceaux.length < 3) {
                    continue;
                }

                String depart = morceaux[0].trim();
                String destination = morceaux[1].trim();
                double cout = Double.parseDouble(morceaux[2].trim());

                graphe.ajouterArc(depart, destination, cout);
            }

            lecteur.close();

        } catch (IOException e) {
            System.out.println("Erreur : impossible de lire le fichier " + nomFichier);
        } catch (NumberFormatException e) {
            System.out.println("Erreur : un coût dans le fichier n'est pas un nombre.");
        }
    }

    /**
     * Enregistre le temps d'exécution d'un algorithme dans un fichier log.
     *
     * @param nomAlgo le nom de l'algorithme
     * @param tempsNano le temps en nanosecondes
     */
    public static void enregistrerTemps(String nomAlgo, long tempsNano) {
        try {
            FileWriter writer = new FileWriter("temps_execution.log", true);
            writer.write(nomAlgo + " : " + tempsNano + " ns\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur : impossible d'écrire dans le fichier log.");
        }
    }
}