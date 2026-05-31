import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArcTest {
    @Test
    public void testCreationArc() {
        Arc arc = new Arc("B", 5.0);
        assertEquals("B", arc.getDestination());
        assertEquals(5.0, arc.getCout());
    }

    @Test
    public void testToString() {
        Arc arc = new Arc("C", 2.0);
        assertEquals("C(2.0)", arc.toString());
    }

}
