import java.util.ArrayList;

/**
 * Implémentation d'un graphe orienté pondéré avec des listes d'adjacence
 */
public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private  ArrayList<Arcs> adjacence;
    public GrapheListe(){
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

    /**
     * Ajoute un arc au graphe, mais si le noeud de départ ou de destination n'existe pas, ils sont ajouté au graphe
     * @param depart noeud de départ
     * @param destination noeud d'arrivé
     * @param cout cout de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }
        int indiceDepart = noeuds.indexOf(depart);
        adjacence.get(indiceDepart).addArc(new Arc(destination, cout));
    }

    public ArrayList<String> listeNoeuds() {
        return this.noeuds;
    }

    public Arcs suivants(String noeud) {
        if(noeuds.contains(noeud)) {
            int indiceNoeud = noeuds.indexOf(noeud);
            return adjacence.get(indiceNoeud);
        }
        return new Arcs();
    }

    /**
     * Affichage du graphe
     * @return affichage du graphe
     */
    public String toString(){
        String res = "";
        for(String n : this.noeuds){
            res +=n + " -> ";
            Arcs arcs = this.adjacence.get(this.noeuds.indexOf(n));
            for(Arc arc : arcs.getArcs()){
                res += arc.getDestination() + "("+arc.getCout()+") ";
            }
            res+='\n';
        }
        return res;
    }
}
