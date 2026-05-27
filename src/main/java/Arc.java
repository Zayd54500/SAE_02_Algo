/**
 * Représente un arc orienté dans un graphe
 * Contient unniquement une destination et un cout
 */
public class Arc {
    private String destination;
    private double cout;

    /**
     * Créer un arc orienté dans un graphe
     *
     * @param d destination de l'arc
     * @param c cout de l'arc
     */
    public Arc(String d, double c){
        this.destination = d;
        this.cout = c;
    }

    /**
     * Renvois la destination de l'arc
     * @return destination de l'arc
     */
    public String getDestination(){
        return this.destination;
    }

    /**
     * Renvois le cout de l'arc
     * @return cout de l'arc
     */
    public double getCout(){
        return this.cout;
    }

    /**
     * Affiche l'arc
     * @return l'affichage de l'arc
     */
    public String toString() {
        return this.destination + "(" + this.cout + ")" ;
    }
}
