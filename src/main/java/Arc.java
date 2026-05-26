public class Arc {
    private String destination;
    private double cout;
    public Arc(String d, int c){
        this.destination = d;
        this.cout = c;
    }
    public String getDestination(){
        return this.destination;
    }
    public double getCout(){
        return this.cout;
    }

    public String toString() {
        return this.destination + "(" + this.cout + ")" ;
    }
}
