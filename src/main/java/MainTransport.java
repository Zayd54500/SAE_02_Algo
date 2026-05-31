/**
 * Programme principal pour la recherche de plus court chemin
 * dans le réseau de transports en commun STAN
 * Usage : java -jar src.jar <id_depart> <id_arrivee>
 */
public class MainTransport {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage : java -jar src.jar <id_depart> <id_arrivee>");
            System.exit(1);
        }

        // Nettoyage des crochets envoyés par la GUI
        String regex = "\\[|\\]";
        String depart = args[0].split(regex)[1];
        String arrivee = args[1].split(regex)[1];

        String fichierStations = "stan.nodes.txt";
        String fichierConnexions = "stan.edges.txt";

        Graphe graphe = LireReseau.lire(fichierStations, fichierConnexions);

        Dijkstra dijkstra = new Dijkstra();
        long startDijkstra = System.nanoTime();
        Valeurs valeursDijkstra = dijkstra.resoudre(graphe, depart);
        long endDijkstra = System.nanoTime();

        BellmanFord bf = new BellmanFord();
        long startBF = System.nanoTime();
        Valeurs valeursBF = bf.calculer(graphe, depart);
        long endBF = System.nanoTime();

        System.err.println("Temps Dijkstra : " + (endDijkstra - startDijkstra) + " ns");
        System.err.println("Temps Bellman-Ford : " + (endBF - startBF) + " ns");

        java.util.ArrayList<String> chemin = valeursDijkstra.calculer(arrivee);
        System.out.println(String.join(";", chemin));
    }
}