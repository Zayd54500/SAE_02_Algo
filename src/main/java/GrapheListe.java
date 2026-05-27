import java.util.ArrayList;

public class GrapheListe implements Graphe {
    private ArrayList<Noeud> noeuds;
    private  ArrayList<Arcs> adjacence;
    public GrapheListe(){
        this.noeuds = new ArrayList<Noeud>();
        this.adjacence = new ArrayList<Arcs>();
    }

    public void ajouterArc(Noeud depart, Noeud destination, double cout) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }

        int indiceDepart = noeuds.indexOf(depart);
        adjacence.get(indiceDepart).addArc(new Arc(destination.getNom(), cout));
    }

    public ArrayList<Noeud> listeNoeuds() {
        return this.noeuds;
    }

    public Arcs suivants(Noeud noeud) {
        if(noeuds.contains(noeud)) {
            int indiceNoeud = noeuds.indexOf(noeud);
            return adjacence.get(indiceNoeud);
        }
        return new Arcs();
    }
}
