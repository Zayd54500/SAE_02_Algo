/**
 * Implémentation de l'algo bellam ford
 */
public class BellmanFord {
    /**
     * calcul le plus court chemin depuis un noeud de départ avec l'algo de bellman ford
     *
     * @param graphe graphe pondéré et orienté utilisé pour le calcul
     * @param depart le noeud de départ du calcul
     * @return un objet Valeurs qui contient pour chaque noeud sa distance minimale
     * depuis le départ et son parent dans le chemin trouvé
     */
    public Valeurs calculer(Graphe graphe, String depart) {
        Valeurs valeur = new Valeurs();
        for (int i = 0; i < graphe.listeNoeuds().size(); i++) {
            String noeud = graphe.listeNoeuds().get(i);

            if (noeud.equals(depart)) {
                valeur.ajouterValeur(noeud, 0.0, null);
            } else {
                valeur.ajouterValeur(noeud, Double.MAX_VALUE, null);
            }
        }
        for (int i = 0; i < graphe.listeNoeuds().size() - 1; i++) {
            for (int j = 0; j < graphe.listeNoeuds().size(); j++) {
                String noeud = graphe.listeNoeuds().get(j);
                Arcs arcs = graphe.suivants(noeud);
                for (int k = 0; k < arcs.getArcs().size(); k++) {
                    Arc arc = arcs.getArcs().get(k);
                    String destination = arc.getDestination();
                    double cout = arc.getCout();
                    double nouvelleValeur = valeur.getValeur(noeud) + cout;

                    if (nouvelleValeur < valeur.getValeur(destination)) {
                        valeur.setValeur(destination,  nouvelleValeur);
                        valeur.setParent(destination, noeud);
                    }
                }
            }
        }
        return valeur;
    }
}
