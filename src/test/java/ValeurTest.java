import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValeurTest {
    @Test
    public void testValeurs() {
        Valeurs valeur = new Valeurs();
        valeur.ajouterValeur("A", 0.0, null);
        valeur.ajouterValeur("B", 5.0, "A");
        valeur.ajouterValeur("C", 2.0, "A");
        valeur.setValeur("B", 3.0);
        valeur.setParent("B", "C");

        assertEquals(0.0, valeur.getValeur());

    }
}
