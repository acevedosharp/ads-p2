package gestor;

import entidades.*;
import proxy.GestorInteface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorProxy implements GestorInteface {

    private final User user;
    private List<Componente> componentes = new ArrayList<Componente>();

    public GestorProxy(User user) throws WrongCredentialsException {
        actualizarComponentes();

        // Verifica que las credenciales existan ;)
        boolean res = componentes.stream().anyMatch(componente -> ((User) componente).getCorreo().equals(user.getCorreo()) && ((User) componente).getContrasena().equals(user.getContrasena()));
        if (!res)
            throw new WrongCredentialsException();
        this.user = user;
    }

    @Override
    public void ejecutarAccion(String accion) throws Exception {
        List<String> params = Arrays.asList(accion.split(","));
        String metodo = params.get(0);

        if (user instanceof Admin) { // puede hacer de todo
            // Un switch ocuparía muchas líneas.
            if (metodo.equals("crearBiciusuario")) GestorSingleton.build().crearBiciusuario(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
            else if (metodo.equals("consultarBiciusuario")) GestorSingleton.build().consultarBiciusuario(params.get(1));
            else if (metodo.equals("actualizarBiciusuario")) GestorSingleton.build().actualizarBiciusuario(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
            else if (metodo.equals("eliminarBiciusuario")) GestorSingleton.build().eliminarBiciusuario(params.get(1));

            else if (metodo.equals("crearEmpresa")) GestorSingleton.build().crearEmpresa(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
            else if (metodo.equals("consultarEmpresa")) GestorSingleton.build().consultarEmpresa(params.get(1));
            else if (metodo.equals("actualizarEmpresa")) GestorSingleton.build().actualizarEmpresa(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
            else if (metodo.equals("eliminarEmpresa")) GestorSingleton.build().eliminarEmpresa(params.get(1));

            else if (metodo.equals("crearComposicionEmpresaEmpresa")) GestorSingleton.build().crearComposicionEmpresaEmpresa(params.get(1), params.get(2));
            else if (metodo.equals("crearComposicionEmpresaEmpleado")) GestorSingleton.build().crearComposicionEmpresaEmpleado(params.get(1), params.get(2));
            else if (metodo.equals("eliminarComposicionEmpresaEmpleado")) GestorSingleton.build().eliminarComposicionEmpresaEmpleado(params.get(1), params.get(2));
            else if (metodo.equals("agregarBicicleta")) GestorSingleton.build().agregarBicicleta(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));

            actualizarComponentes();

        } else if (user instanceof Empresa) {
            String ownNit = ((Empresa) user).getNIT();

            if (metodo.equals("actualizarEmpresa")) GestorSingleton.build().actualizarEmpresa(ownNit, params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
            else if (metodo.equals("eliminarEmpresa")) GestorSingleton.build().eliminarEmpresa(ownNit);
            else if (metodo.equals("crearComposicionEmpresaEmpleado")) GestorSingleton.build().crearComposicionEmpresaEmpleado(ownNit, params.get(2));
            else if (metodo.equals("eliminarComposicionEmpresaEmpleado")) GestorSingleton.build().eliminarComposicionEmpresaEmpleado(ownNit, params.get(2));
            actualizarComponentes();

        } else if (user instanceof Biciusuario) {
            String ownId = ((Biciusuario) user).getId();
            if (metodo.equals("actualizarBiciusuario")) GestorSingleton.build().actualizarBiciusuario(ownId, params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
            else if (metodo.equals("eliminarBiciusuario")) GestorSingleton.build().eliminarBiciusuario(ownId);
            else if (metodo.equals("agregarBicicleta")) GestorSingleton.build().agregarBicicleta(ownId, params.get(2), params.get(3), params.get(4), params.get(5), params.get(6));
        }
    }

    private void actualizarComponentes() {
        componentes = GestorSingleton.build().getComponentes();
    }
}
