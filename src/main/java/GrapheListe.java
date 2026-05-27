import java.util.ArrayList;

public class GrapheListe implements Graphe {
    private ArrayList<Noeud> noeuds;
    private  ArrayList<Arcs> suivant;
    public GrapheListe(){
        this.noeuds = new ArrayList<Noeud>();
        this.suivant = new ArrayList<Arcs>();
    }
    public ArrayList<Noeud> getNoeuds(){
        return this.noeuds;
    }
    public ArrayList<Arc> getSuivant(String noeud){

    }
    public void ajoutArc(Noeud source, String destination, int poids){
        Arc a = new Arc(destination, poids);
    }
}
