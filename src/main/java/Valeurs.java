import java.util.ArrayList;

public class Valeurs {
    private ArrayList<String> noeuds;
    private ArrayList<Double> valeurs;
    private ArrayList<String> parents;

    public Valeurs() {
        this.noeuds = new ArrayList<>();
        this.valeurs = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void ajouterValeur(String noeud, double valeur, String parent) {
        noeuds.add(noeud);
        valeurs.add(valeur);
        parents.add(parent);
    }

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

    public String toString() {
        String resultat = "";
        for (int i  = 0; i < noeuds.size(); i++) {
            resultat = resultat + noeuds.get(i) + " -> Valeur : " + valeurs.get(i) + " Parent : " + parents.get(i) + "\n";
        }
        return resultat;
    }
}
