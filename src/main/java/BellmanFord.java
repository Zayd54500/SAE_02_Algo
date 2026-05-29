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
    }
}
