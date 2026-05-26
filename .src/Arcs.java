import java.util.ArrayList;

public class Arcs {
    private ArrayList<Arc> liste;
    public Arcs(){
        this.liste = new ArrayList<Arc>();
    }
    public void ajoutArc(Arc a){
        this.liste.add(a);
    }
    public ArrayList<Arc> getListe(){
        return this.liste;
    }
}

