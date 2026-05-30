import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ArcsTest {
    @Test
    public void testArcsVideDepart() {
        Arcs arcs = new Arcs();
        assertEquals(0, arcs.getArcs().size());
    }

    @Test
    public void testAjouterArc() {
        Arcs arcs = new Arcs();
        Arc arc = new Arc("B", 5.0);
        arcs.addArc(arc);
        assertEquals(1, arcs.getArcs().size());
        assertEquals("B", arcs.getArcs().get(0).getDestination());
        assertEquals(5.0, arcs.getArcs().get(0).getCout());
    }

    @Test
    public void testAjouterPlusieursArcs() {
        Arcs arcs = new Arcs();
        arcs.addArc(new Arc("B", 5.0));
        arcs.addArc(new Arc("C", 2.0));
        assertEquals(2, arcs.getArcs().size());
        assertEquals("B", arcs.getArcs().get(0).getDestination());
        assertEquals("C", arcs.getArcs().get(1).getDestination());
    }

    @Test
    public void testToStringArcs() {
        Arcs arcs = new Arcs();
        arcs.addArc(new Arc("B", 5.0));
        arcs.addArc(new Arc("C", 2.0));
        assertEquals("[B(5.0), C(2.0)]", arcs.toString());
    }
}
