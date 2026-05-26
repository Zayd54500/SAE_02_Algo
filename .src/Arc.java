public class Arc {
    private String cible;
    private int poids;
    public Arc(String c, int p){
        this.cible = c;
        this.poids = p;
    }
    public String getCible(){
        return this.cible;
    }
    public int getPoids(){
        return this.poids;
    }
}
