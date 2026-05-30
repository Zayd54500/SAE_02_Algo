import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BellmanFordTest {
    @Test
    public void testBellmanFordSimple() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 5.0);
        graphe.ajouterArc("A", "C", 2.0);
        graphe.ajouterArc("C", "B", 1.0);

        BellmanFord bellmanFord = new BellmanFord();
        Valeurs valeurs = bellmanFord.calculer(graphe, "A");

        assertEquals(0.0, valeurs.getValeur("A"));
        assertEquals(2.0, valeurs.getValeur("C"));
        assertEquals(3.0, valeurs.getValeur("B"));
        assertNull(valeurs.getParent("A"));
        assertEquals("A", valeurs.getParent("C"));
        assertEquals("C", valeurs.getParent("B"));
    }

    public void testBellmandFordPlusieursArcs() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 10.0);
        graphe.ajouterArc("A", "C", 2.0);
        graphe.ajouterArc("C", "D", 2.0);
        graphe.ajouterArc("D", "B", 1.0);

        BellmanFord bellmanFord = new BellmanFord();
        Valeurs valeurs = bellmanFord.calculer(graphe, "A");

        assertEquals(0.0, valeurs.getValeur("A"));
        assertEquals(2.0, valeurs.getValeur("C"));
        assertEquals(4.0, valeurs.getValeur("D"));
        assertEquals(5.0, valeurs.getValeur("B"));

        assertNull(valeurs.getParent("A"));
        assertEquals("A", valeurs.getParent("C"));
        assertEquals("C", valeurs.getParent("D"));
        assertEquals("D", valeurs.getParent("B"));
    }

    @Test
    public void testBellmanFordChemin() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 10.0);
        graphe.ajouterArc("A", "C", 2.0);
        graphe.ajouterArc("C", "D", 2.0);
        graphe.ajouterArc("D", "B", 1.0);

        BellmanFord bellmanFord = new BellmanFord();
        Valeurs valeurs = bellmanFord.calculer(graphe, "A");
        ArrayList<String> chemin = valeurs.calculer("B");

        assertEquals("A", chemin.get(0));
        assertEquals("C", chemin.get(1));
        assertEquals("D", chemin.get(2));
        assertEquals("B", chemin.get(3));

    }
}
