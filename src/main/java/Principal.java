public class Principal {
    public static void main(String[] args) {
        Noeud a = new Noeud("A", "A");
        Noeud b = new Noeud("B", "B");
        Noeud c = new Noeud("C", "C");
        Noeud d = new Noeud("D", "D");
        Noeud e = new Noeud("E", "E");
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
    }
}
