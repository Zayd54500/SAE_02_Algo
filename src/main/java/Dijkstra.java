import java.util.ArrayList;

/**
 * Implémentation de l'algo de Dijkstra
 */
public class Dijkstra {
    /**
     * Calcule le plus court chemins depuis un noeud de départ avec l'algo de dijkstra
     *
     * @param g le graphe orienté et pondéré qu'on utilise pour le calcul
     * @param depart le noeud de départ du calcul
     * @return un objet Valeurs contenant pour chaque noeud sa distance minimale depuis le départ
     * et son parent dans le chemin trouvé
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        ArrayList<String> aTraiter = new ArrayList<>();
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            String noeud = g.listeNoeuds().get(i);
            aTraiter.add(noeud);
            if (noeud.equals(depart)) {
                valeurs.ajouterValeur(noeud, 0.0, null);
            } else {
                valeurs.ajouterValeur(noeud, Double.POSITIVE_INFINITY, null);
            }
        }
        while (!aTraiter.isEmpty()) {
            String noeudMinimumProvisoire = aTraiter.get(0);
            for (int i = 1; i < aTraiter.size(); i++) {
                String noeud = aTraiter.get(i);
                if (valeurs.getValeur(noeud) < valeurs.getValeur(noeudMinimumProvisoire)) {
                    noeudMinimumProvisoire = noeud;
                }
            }
            aTraiter.remove(noeudMinimumProvisoire);
            Arcs arcs = g.suivants(noeudMinimumProvisoire);
            for (int j = 0; j < arcs.getArcs().size(); j++) {
                Arc arc = arcs.getArcs().get(j);
                String destination = arc.getDestination();
                double cout = arc.getCout();
                double nouvelleValeur = valeurs.getValeur(noeudMinimumProvisoire) + cout;

                if (nouvelleValeur < valeurs.getValeur(destination)) {
                    valeurs.setValeur(destination, nouvelleValeur);
                    valeurs.setParent(destination, noeudMinimumProvisoire);
                }
            }
        }
        return valeurs;
    }
}
