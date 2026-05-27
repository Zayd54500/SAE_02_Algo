import java.util.ArrayList;

/**
 * Représente une liste d'arc qui sort d'un noeud du graphe
 */
public class Arcs {
    private ArrayList<Arc> arcs;

    public Arcs(){
        this.arcs = new ArrayList<Arc>();
    }

    /**
     * Ajoute un arc à la liste d'arcs
     * @param a arc à ajouter
     */
    public void addArc(Arc a){
        this.arcs.add(a);
    }

    /**
     * Renvois la liste d'arcs
     * @return liste des arcs
     */
    public ArrayList<Arc> getArcs(){
        return this.arcs;
    }

    /**
     * Affichage des arcs
     * @return affichage des arcs
     */
    public String toString() {
        return this.arcs.toString();
    }
}

