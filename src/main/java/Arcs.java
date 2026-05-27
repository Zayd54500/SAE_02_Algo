import java.util.ArrayList;

public class Arcs {
    private ArrayList<Arc> arcs;

    public Arcs(){
        this.arcs = new ArrayList<Arc>();
    }

    public void addArc(Arc a){
        this.arcs.add(a);
    }

    public ArrayList<Arc> getArcs(){
        return this.arcs;
    }

    public String toString() {
        return this.arcs.toString();
    }
}

