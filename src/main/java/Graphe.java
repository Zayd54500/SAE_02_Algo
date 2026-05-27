import java.util.ArrayList;

public interface Graphe {
    public void ajouterArc(Noeud depart, Noeud destination, double cout);
    public ArrayList<Noeud> listeNoeuds();
    public Arcs suivants(String noeud);
}