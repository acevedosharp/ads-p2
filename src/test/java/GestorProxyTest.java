import entidades.Admin;
import entidades.Biciusuario;
import entidades.Componente;
import entidades.Empresa;
import gestor.*;
import org.junit.Test;
import static org.junit.Assert.*;
import proxy.GestorInteface;

public class GestorProxyTest {
    private final String biciusuario1Id = "123";
    private final String biciusuario1Correo = "acevedosharp@hotmail.com";
    private final String biciusuario1Contrasena = "Password123";
    private final String biciusuario1Nombre = "Jose Acevedo";
    private final String biciusuario1Direccion = "Barrancabermeja";
    private final String biciusuario1Telefono = "3022175285";

    private final String biciusuario2Id = "456";
    private final String biciusuario2Correo = "joseacpo@unisabana.edu.co";
    private final String biciusuario2Contrasena = "Password123";
    private final String biciusuario2Nombre = "León de Greiff";
    private final String biciusuario2Direccion = "Barrancabermeja";
    private final String biciusuario2Telefono = "3022175286";

    private final String empresa1Nit = "321";
    private final String empresa1Correo = "empresita@hotmail.com";
    private final String empresa1Contrasena = "Passssss123";
    private final String empresa1Nombre = "Empresita LLC";
    private final String empresa1Direccion = "Bogotá D.C.";
    private final String empresa1Telefono = "3022175287";

    private final String empresa2Nit = "654";
    private final String empresa2Correo = "empresovsky@hotmail.com";
    private final String empresa2Contrasena = "Passssss123";
    private final String empresa2Nombre = "Empresovsky LLC";
    private final String empresa2Direccion = "Bogotá D.C.";
    private final String empresa2Telefono = "3022175288";

    public GestorProxyTest() throws IllegalEmailException, IllegalPasswordException {
        GestorSingleton.build().crearBiciusuario(biciusuario1Id, biciusuario1Correo, biciusuario1Contrasena, biciusuario1Nombre, biciusuario1Direccion, biciusuario1Telefono);
        GestorSingleton.build().crearBiciusuario(biciusuario2Id, biciusuario2Correo, biciusuario2Contrasena, biciusuario2Nombre, biciusuario2Direccion, biciusuario2Telefono);
        GestorSingleton.build().crearEmpresa(empresa1Nit, empresa1Correo, empresa1Contrasena, empresa1Nombre, empresa1Direccion, empresa1Telefono);
        GestorSingleton.build().crearEmpresa(empresa2Nit, empresa2Correo, empresa2Contrasena, empresa2Nombre, empresa2Direccion, empresa2Telefono);
    }

    @Test(expected = WrongCredentialsException.class)
    public void userWithWrongCredentials() throws WrongCredentialsException {
        new GestorProxy(new Biciusuario("c", "p", "n", "d", "t", "i"));
    }

    @Test
    public void userWithCorrectCredentials() throws WrongCredentialsException {
        new GestorProxy(GestorSingleton.build().consultarBiciusuario(biciusuario1Id));
    }

    @Test
    public void adminCanDoAnything() throws Exception {
        GestorInteface gestor = new GestorProxy(new Admin("movelo@hotmail.com", "Password123"));

        gestor.ejecutarAccion("agregarBicicleta,"+biciusuario1Id+",s,m,c,e,m");

        int l = GestorSingleton.build().consultarBiciusuario(biciusuario1Id).getBicicletas().size();

        gestor.ejecutarAccion("crearComposicionEmpresaEmpresa,"+empresa1Nit+","+empresa2Nit);

        Componente res = GestorSingleton.build().consultarEmpresa(empresa1Nit).getComponentes().get(0);

        assertTrue(l > 0 && res instanceof Empresa);
    }
}
