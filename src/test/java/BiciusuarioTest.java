import decorator.Bicicleta;
import entidades.BicicletaImpl;
import entidades.Biciusuario;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BiciusuarioTest {

    private final String correo = "acevedosharp@hotmail.com";
    private final String password = "Password123";
    private final String nombre = "Jose";
    private final String direccion = "Barrancabermeja";
    private final String telefono = "30221752885";
    private final String id = "1";

    @Test
    public void createBiciusuario() {
        Biciusuario biciusuario = new Biciusuario(correo, password, nombre, direccion, telefono, id);

        assertTrue(
                biciusuario.getCorreo().equals(correo) &&
                        biciusuario.getContrasena().equals(password) &&
                        biciusuario.getNombre().equals(nombre) &&
                        biciusuario.getDireccion().equals(direccion) &&
                        biciusuario.getTelefono().equals(telefono)
        );
    }

    @Test
    public void editBiciusuario() {
        Biciusuario biciusuario = new Biciusuario(correo, password, nombre, direccion, telefono, id);

        String newCorreo =  "joseacpo@unisabana.edu.co";
        String newPass = "NewPass123";
        String newNombre = "León de Greiff";
        String newDireccion = "Chía";
        String newTelefono = "3022175285";

        biciusuario.setCorreo(newCorreo);
        biciusuario.setContrasena(newPass);
        biciusuario.setNombre(newNombre);
        biciusuario.setDireccion(newDireccion);
        biciusuario.setTelefono(newTelefono);

        assertTrue(
                biciusuario.getCorreo().equals(newCorreo) &&
                        biciusuario.getContrasena().equals(newPass) &&
                        biciusuario.getNombre().equals(newNombre) &&
                        biciusuario.getDireccion().equals(newDireccion) &&
                        biciusuario.getTelefono().equals(newTelefono)
        );
    }

    @Test
    public void anadirBicicletaYConsultar() {
        Biciusuario biciusuario = new Biciusuario(correo, password, nombre, direccion, telefono, id);

        Bicicleta bicicleta = new BicicletaImpl("XXX", "Toyota", "Vantablack");
        biciusuario.agregarBicicleta(bicicleta);

        boolean res = biciusuario.getBicicletas().contains(bicicleta);

        assertTrue(res);
    }
}
