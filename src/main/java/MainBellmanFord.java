/**
 * Programme principal pour l'algorithme de Bellman-Ford
 * Crée un graphe exemple et affiche le plus court chemin entre deux noeuds
 */
public class MainBellmanFord {
    public static void main(String[] args) {
        // Création du graphe de l'exemple (Figure 1 du sujet)
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        System.out.println("Graphe :");
        System.out.println(g);

        // Calcul du plus court chemin depuis A
        BellmanFord bf = new BellmanFord();
        Valeurs valeurs = bf.calculer(g, "A");

        System.out.println("Valeurs calculées par Bellman-Ford :");
        System.out.println(valeurs);

        // Affichage du chemin vers C
        String destination = "C";
        System.out.println("Chemin de A vers " + destination + " : " + valeurs.calculer(destination));
        System.out.println("Distance : " + valeurs.getValeur(destination));
    }
}