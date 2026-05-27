public class BellmanFord {
    public Valeurs calculer(GrapheListe g, String depart){

        Valeurs vieux = new Valeurs();
        for(String noeud : g.listeNoeuds()){
            if (noeud.equals(depart)){
                vieux.ajouterValeur(noeud, 0.0, null);
            }
            vieux.ajouterValeur(noeud, Double.MAX_VALUE, null);
        }

        boolean changement = true;
        while(changement) {
            changement = false;
            for (String noeud : g.listeNoeuds()) {
                double coutMin = Double.MAX_VALUE;
                String noeudMin = "";
                if (vieux.getValeur(noeud) != Double.MAX_VALUE) {
                    for (Arc arc : g.suivants(noeud).getArcs()) {
                        if (arc.getCout() + vieux.getValeur(noeud) < coutMin) {
                            coutMin = arc.getCout()+vieux.getValeur(noeud);
                            noeudMin = arc.getDestination();
                        }
                    }
                    vieux.setValeur(noeudMin, coutMin);
                    vieux.setParent(noeud, noeudMin);
                    changement = true;
                }
            }
        }
        return vieux;
    }
}
