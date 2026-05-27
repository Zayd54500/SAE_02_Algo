import java.util.ArrayList;
import java.util.Collections;

/**
 * Stocke les valeurs calculées par les algos (bellman-ford et dijkstra)
 * pour chaque noeud on garde le parent et la distance depuis le départ
 */
public class Valeurs {
    private ArrayList<String> noeuds;
    private ArrayList<Double> valeurs;
    private ArrayList<String> parents;

    public Valeurs() {
        this.noeuds = new ArrayList<>();
        this.valeurs = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    /**
     * Ajoute un noeud avec sa valeur et son parent
     * @param noeud nom du noeud
     * @param valeur distance associé au noeud
     * @param parent parent du noeud dans le chemin
     */
    public void ajouterValeur(String noeud, double valeur, String parent) {
        noeuds.add(noeud);
        valeurs.add(valeur);
        parents.add(parent);
    }

    /**
     * Renvois la valeur associé à un noeud
     * @param noeud noeud recherché
     * @return valeur du noeud, ou l'infini si le noeud n'existe pas
     */
    public double getValeur(String noeud) {
        if (noeuds.contains(noeud)) {
            int indiceNoeud = noeuds.indexOf(noeud);
            return valeurs.get(indiceNoeud);
        }
        return Double.MAX_VALUE;
    }

    /**
     * Renvoie le parent associé à un noeud
     * @param noeud noeur recherché
     * @return parent du noeud recherché, ou null si aucun parent n'exite
     */
    public String getParent(String noeud) {
        if(noeuds.contains(noeud)) {
            int indiceNoeud = noeuds.indexOf(noeud);
            return parents.get(indiceNoeud);
        }
        return null;
    }

    public void setValeur(String noeud, double valeur) {
        int indiceNoeud = noeuds.indexOf(noeud);
        valeurs.set(indiceNoeud, valeur);
    }

    public void setParent(String noeud, String parent) {
        if (noeuds.contains(noeud)) {
            int indiceNoeud = noeuds.indexOf(noeud);
            parents.set(indiceNoeud, parent);
        }
    }

    /**
     * Reconstruit le chemin depuis le noeud de départ jusqu'à une destination en remontant les parents
     * @param destination noeud d'arrivé
     * @return liste des noeuds formant le chemin
     */
    public ArrayList<String> calculer(String destination) {
        ArrayList<String> chemin = new ArrayList<>();

        String noeudCourant = destination;
        while(noeudCourant != null) {
            chemin.add(noeudCourant);
            noeudCourant = getParent(noeudCourant);
        }
        Collections.reverse(chemin);
        return chemin;
    }

    public String toString() {
        String resultat = "";
        for (int i  = 0; i < noeuds.size(); i++) {
            resultat = resultat + noeuds.get(i) + " -> Valeur : " + valeurs.get(i) + " Parent : " + parents.get(i) + "\n";
        }
        return resultat;
    }
}