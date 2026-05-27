import java.util.ArrayList;

/**
 * Interface représentant un graphe orienté et pondéré
 */
public interface Graphe {
    /**
     * Ajoute un arc orienté entre deux noeuds avec un cout donné
     * @param depart noeud de départ
     * @param destination noeud d'arrivé
     * @param cout cout de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout);

    /**
     * Renvois la liste de noeud du graphe
     * @return liste des noms des noeuds
     */
    public ArrayList<String> listeNoeuds();

    /**
     *  Renvois les arcs sortant d'un noeud donné
     * @param noeud noeud dont on cherche les successeur
     * @return liste d'arcs sortant du noeud
     */
    public Arcs suivants(String noeud);
}