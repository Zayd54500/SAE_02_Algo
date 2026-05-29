public class BellmanFord {
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
