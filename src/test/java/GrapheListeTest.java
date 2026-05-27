import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrapheListeTest {
    @Test
    public void testAjoutArcEtSuivants() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 5.0);
        graphe.ajouterArc("A", "C", 2.0);
        graphe.ajouterArc("C", "B", 1.0);

        assertEquals("[A, B, C]", graphe.listeNoeuds().toString());

        assertEquals("[B(5.0), C(2.0)]", graphe.suivants("A").toString());
        assertEquals("[]", graphe.suivants("B").toString());
        assertEquals("[B(1.0)]", graphe.suivants("C").toString());
    }
}
