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
    public ArrayList<Arcs> getSuivant(){
        ArrayList<Arcs> l = new ArrayList<Arcs>();
        for(int i = 0; i<this.noeuds.size(); i++){
            l.add(this.noeuds.get(i))
        }
    }
}
