import java.util.ArrayList;

public interface Graphe {
    ArrayList<Noeud> getNoeuds();
    ArrayList<Arc> getSuivant(String noeud);
}