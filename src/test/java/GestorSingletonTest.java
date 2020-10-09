import entidades.Biciusuario;
import entidades.Empresa;
import gestor.IllegalEmailException;
import gestor.IllegalPasswordException;
import gestor.GestorSingleton;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestorSingletonTest {
    private final String validEmail = "acevedosharp@hotmail.com";
    private final String validPassword = "Password123";
    private final String name = "Jose";
    private final String direccion = "Barrancabermeja";
    private final String telefono = "3022175285";
    private final String id = "1";
    private final String nit = "1";

    @Test
    public void createBiciusuarioUnique() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);
        boolean res = GestorSingleton.build().crearBiciusuario("uniqueId", validEmail, validPassword, name, direccion, telefono);

        assertTrue(res);
    }

    @Test
    public void createBiciusuarioNotUnique() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);
        boolean res = GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);

        assertFalse(res);
    }

    @Test
    public void consultarBiciusuarioExitoso() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);
        Biciusuario res = GestorSingleton.build().consultarBiciusuario(id);

        assertNotNull(res);
    }

    @Test
    public void consultarBiciusuarioFallido() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);
        Biciusuario res = GestorSingleton.build().consultarBiciusuario("otherId");

        assertNull(res);
    }

    @Test
    public void actualizarBiciusuarioExitoso() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);
        String newCorreo = "joseacpo@unisabana.edu.co";
        String newPass = "myPassss12123";
        String newName = "León de Greiff";
        String newDireccion = "Chía";
        String newTelefono = "3022175286";

        boolean res = GestorSingleton.build().actualizarBiciusuario(id, newCorreo, newPass, newName, newDireccion, newTelefono);

        assertTrue(res);
    }

    @Test
    public void actualizarBiciusuarioFallido() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);
        String newCorreo = "joseacpo@unisabana.edu.co";
        String newPass = "myPassss12123";
        String newName = "León de Greiff";
        String newDireccion = "Chía";
        String newTelefono = "3022175286";

        boolean res = GestorSingleton.build().actualizarBiciusuario("otherId", newCorreo, newPass, newName, newDireccion, newTelefono);

        assertFalse(res);
    }

    @Test
    public void eliminarBiciusuarioExitoso() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);

        boolean res = GestorSingleton.build().eliminarBiciusuario(id);

        assertTrue(res);
    }

    @Test
    public void eliminarBiciusuarioFallido() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearBiciusuario(id, validEmail, validPassword, name, direccion, telefono);

        boolean res = GestorSingleton.build().eliminarBiciusuario("otherId");

        assertFalse(res);
    }

    @Test
    public void createEmpresaUnique() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);
        boolean res = GestorSingleton.build().crearBiciusuario("uniqueNit", validEmail, validPassword, name, direccion, telefono);

        assertTrue(res);
    }

    @Test
    public void createEmpresaNotUnique() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);
        boolean res = GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);

        assertFalse(res);
    }

    @Test
    public void consultarEmpresaExitoso() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);
        Empresa res = GestorSingleton.build().consultarEmpresa(nit);

        assertNotNull(res);
    }

    @Test
    public void consultarEmpresaFallido() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);
        Empresa res = GestorSingleton.build().consultarEmpresa("otherId");

        assertNull(res);
    }

    @Test
    public void actualizarEmpresaExitoso() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);
        String newCorreo = "joseacpo@unisabana.edu.co";
        String newPass = "myPassss12123";
        String newName = "León de Greiff";
        String newDireccion = "Chía";
        String newTelefono = "3022175286";

        boolean res = GestorSingleton.build().actualizarEmpresa(nit, newCorreo, newPass, newName, newDireccion, newTelefono);

        assertTrue(res);
    }

    @Test
    public void actualizarEmpresaFallido() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);
        String newCorreo = "joseacpo@unisabana.edu.co";
        String newPass = "myPassss12123";
        String newName = "León de Greiff";
        String newDireccion = "Chía";
        String newTelefono = "3022175286";

        boolean res = GestorSingleton.build().actualizarEmpresa("otherId", newCorreo, newPass, newName, newDireccion, newTelefono);

        assertFalse(res);
    }

    @Test
    public void eliminarEmpresaExitoso() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);

        boolean res = GestorSingleton.build().eliminarEmpresa(nit);

        assertTrue(res);
    }

    @Test
    public void eliminarEmpresaFallido() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa(nit, validEmail, validPassword, name, direccion, telefono);

        boolean res = GestorSingleton.build().eliminarEmpresa("otherId");

        assertFalse(res);
    }

    @Test
    public void validUser() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", validEmail, validPassword, "n", "d", "t");
    }

    @Test(expected = IllegalPasswordException.class)
    public void shortPassword() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", validEmail, "mini5", "n", "d", "t");
    }

    @Test(expected = IllegalPasswordException.class)
    public void noLetterPassword() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", validEmail, "1234567890", "n", "d", "t");
    }

    @Test(expected = IllegalPasswordException.class)
    public void noNumberPassword() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", validEmail, "abcdefghi", "n", "d", "t");
    }


    @Test(expected = IllegalEmailException.class)
    public void noAtEmail() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", "acevedosharp.com", validPassword, "n", "d", "t");
    }

    @Test(expected = IllegalEmailException.class)
    public void noTLDEmail() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", "acevedosharp@hotmail", validPassword, "n", "d", "t");
    }

    @Test(expected = IllegalEmailException.class)
    public void noPreAtEmail() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().flushInstanceData();

        GestorSingleton.build().crearEmpresa("1", "@hotmail.com", validPassword, "n", "d", "t");
    }
}
