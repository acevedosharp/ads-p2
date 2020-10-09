import entidades.BicicletaImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicicletaTest {

    private final String serial = "XXX";
    private final String marca = "Toyota";
    private final String color = "Vantablack";

    @Test
    public void createSimpleBicicleta() {
        BicicletaImpl bicicleta = new BicicletaImpl(serial, marca, color);

        assertTrue(
                bicicleta.getSerial().equals(serial) &&
                        bicicleta.getMarca().equals(marca) &&
                        bicicleta.getColor().equals(color)
        );
    }

    @Test
    public void editSimpleBicicleta() {
        BicicletaImpl bicicleta = new BicicletaImpl(serial, marca, color);

        String newSerial = "ZZZ";
        String newMarca = "BMW";
        String newColor = "Brown";

        bicicleta.setSerial(newSerial);
        bicicleta.setMarca(newMarca);
        bicicleta.setColor(newColor);

        assertTrue(
                bicicleta.getSerial().equals(newSerial) &&
                        bicicleta.getMarca().equals(newMarca) &&
                        bicicleta.getColor().equals(newColor)
        );
    }
}
