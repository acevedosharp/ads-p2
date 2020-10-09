import entidades.Biciusuario;
import entidades.Empresa;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmpresaTest {

    private final String correo = "empresita@hotmail.com";
    private final String password = "Password123";
    private final String nombre = "Empresita LLC";
    private final String direccion = "Bogotá D.C.";
    private final String telefono = "3022175285";
    private final String nit = "1";

    @Test
    public void createEmpresa() {
        Empresa empresa = new Empresa(correo, password, nombre, direccion, telefono, nit);

        assertTrue(
                empresa.getCorreo().equals(correo) &&
                        empresa.getContrasena().equals(password) &&
                        empresa.getNombre().equals(nombre) &&
                        empresa.getDireccion().equals(direccion) &&
                        empresa.getTelefono().equals(telefono)
        );
    }

    @Test
    public void editSimpleBicicleta() {
        Empresa empresa = new Empresa(correo, password, nombre, direccion, telefono, nit);

        String newCorreo =  "empresovsky@unisabana.edu.co";
        String newPass = "NewPass123";
        String newNombre = "Empresovsky LLC";
        String newDireccion = "Chía"; // less crowded!
        String newTelefono = "3022175286";

        empresa.setCorreo(newCorreo);
        empresa.setContrasena(newPass);
        empresa.setNombre(newNombre);
        empresa.setDireccion(newDireccion);
        empresa.setTelefono(newTelefono);

        assertTrue(
                empresa.getCorreo().equals(newCorreo) &&
                        empresa.getContrasena().equals(newPass) &&
                        empresa.getNombre().equals(newNombre) &&
                        empresa.getDireccion().equals(newDireccion) &&
                        empresa.getTelefono().equals(newTelefono)
        );
    }

    @Test
    public void crearComposicionYVerificar() {
        Empresa empresa = new Empresa(correo, password, nombre, direccion, telefono, nit);

        Biciusuario biciusuario = new Biciusuario("acevedosharp@hotmail.com", "Password123", "Jose Acevedo", "Barrancabermeja", "3022175285", "1");

        empresa.agregarComponente(biciusuario);

        boolean res = empresa.getComponentes().contains(biciusuario);

        assertTrue(res);
    }
}
