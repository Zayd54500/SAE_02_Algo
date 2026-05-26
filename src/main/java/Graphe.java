import java.util.ArrayList;

public interface Graphe {
    public void ajouterArc(String depart, String destination, double cout);
    public ArrayList<String> listeNoeuds();
    public Arcs suivants(String noeud);
}