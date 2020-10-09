import entidades.Biciusuario;
import org.junit.Test;


public class BiciusuarioTest {

    private String correo = "acevedosharp@hotmail.com";
    private String password = "Password123";
    private String nombre = "Jose";
    private String direccion = "Barrancabermeja";
    private String telefono = "30221752885";
    private String id = "1005221892";

    @Test
    public void successfulCreation() throws Exception {
        Biciusuario biciusuario = new Biciusuario(correo, password, nombre, direccion, telefono, id);
    }

}
