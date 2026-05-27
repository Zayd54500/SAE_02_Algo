import java.util.ArrayList;

public class Noeud {
    private String identifiant;
    private String nom;
    private Arcs liste;
    public Noeud(String id, String n){
        this.identifiant = id;
        this.nom = n;
        this.liste = new Arcs();
    }
    public String getId(){
        return this.identifiant;
    }
    public String getNom(){
        return this.nom;
    }
    public Arcs getListe(){
        return this.liste;
    }
}
