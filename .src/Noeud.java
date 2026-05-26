import java.util.ArrayList;

public class Noeud {
    private String identifiant;
    private String nom;
    private ArrayList<Noeud> liste;
    public Noeud(String id, String n){
        this.identifiant = id;
        this.nom = n;
        this.liste = new ArrayList<Noeud>();
    }
    public String getId(){
        return this.identifiant;
    }
}
