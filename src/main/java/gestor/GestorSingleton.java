package gestor;

import decorator.Bicicleta;
import decorator.EdadDecorator;
import decorator.MaterialDecorator;
import entidades.BicicletaImpl;
import entidades.Biciusuario;
import entidades.Componente;
import entidades.Empresa;

import java.util.ArrayList;

public class GestorSingleton {

    private final ArrayList<Componente> componentes = new ArrayList<Componente>();
    private static GestorSingleton gestorSingleton = null;


    public static GestorSingleton build() {
        if (gestorSingleton == null) {
            gestorSingleton = new GestorSingleton();
        }
        return gestorSingleton;
    }


    public boolean crearBiciusuario(String id, String correo, String contrasena, String name, String direccion, String telefono) {
        if (indexOf(id, "Biciusuario") == -1) {
            componentes.add(new Biciusuario(correo, contrasena, id, name, direccion, telefono));
            System.out.println("Se agregó el biciusuario con ID " + id);
            return true;
        } else {
            System.out.println("No se agregó el usuario. Id de Biciusuario ya existe");
            return false;
        }
    }
    public Biciusuario consultarBiciusuario(String id) {
        int index = indexOf(id, "Biciusuario");
        if (index > -1) {
            return ((Biciusuario) componentes.get(index));
        } else {
            System.out.println("Id de Biciusuario no encontrado");
            return null;
        }
    }
    public boolean actualizarBiciusuario(String id, String correo, String password, String nombre, String direccion, String telefono) {
        int index = indexOf(id, "Biciusuario");
        if (index > -1) {
            ((Biciusuario) componentes.get(index)).setCorreo(correo);
            ((Biciusuario) componentes.get(index)).setContrasena(password);
            ((Biciusuario) componentes.get(index)).setNombre(nombre);
            ((Biciusuario) componentes.get(index)).setDireccion(direccion);
            ((Biciusuario) componentes.get(index)).setTelefono(telefono);
            return true;
        } else {
            System.out.println("Id de Biciusuario no encontrado");
            return false;
        }
    }
    public boolean eliminarBiciusuario(String id) {
        int index = indexOf(id, "Biciusuario");

        if (index > -1) {
            componentes.remove(index);
            return true;
        } else {
            System.out.println("Id de biciusuario no existe");
            return false;
        }
    }

    public boolean crearEmpresa(String nit, String correo, String contrasena, String nombre, String direccion, String telefono) {
        if (indexOf(nit, "Empresa") == -1) {
            componentes.add(new Empresa(correo, contrasena, nombre, direccion, telefono, nit));
            System.out.println("Se agregó empresa con NIT " + nit);
            return true;
        } else {
            System.out.println("Empresa no agregada. Ya existe otra empresa con ese NIT");
            return false;
        }
    }
    public Empresa consultarEmpresa(String nit) {
        int index = indexOf(nit, "Empresa");

        if (index > -1) {
            return ((Empresa) componentes.get(index));
        } else {
            System.out.println("NIT de Empresa no encontrado");
            return null;
        }
    }
    public boolean actualizarEmpresa(String nit, String correo, String contrasena, String nombre, String direccion, String telefono) {
        int index = indexOf(nit, "Empresa");
        if (index > -1) {
            ((Empresa) componentes.get(index)).setCorreo(correo);
            ((Empresa) componentes.get(index)).setContrasena(contrasena);
            ((Empresa) componentes.get(index)).setNombre(nombre);
            ((Empresa) componentes.get(index)).setDireccion(direccion);
            ((Empresa) componentes.get(index)).setTelefono(telefono);
            return true;
        } else {
            System.out.println("NIT de Empresa no encontrado");
            return false;
        }
    }
    public boolean eliminarEmpresa(String nit) {
        ArrayList<String> testamento = new ArrayList<String>();
        boolean exito = false;
        int index = indexOf(nit, "Empresa");

        if (index > -1) {
            //Esta empresa tiene hijos?
            if (((Empresa) componentes.get(index)).getComponentes().size() > 0) {
                //Muestra los hijos
                for (int i = 0; i < ((Empresa) componentes.get(index)).getComponentes().size(); i++) {
                    //Estos hijos son otras empresas?
                    if ((((Empresa) componentes.get(index)).getComponentes().get(i)) instanceof Empresa) {
                        //Recolecta los nombres de los hijos para luego borrarlos
                        testamento.add(((Empresa) ((Empresa) componentes.get(index)).getComponentes().get(i)).getNIT());
                    }
                }
                //Se borran los hijos registrados, no sin antes verificar que ellos no tengan mas hijos, y asi sucesivamente
                for (int i = 0; i < testamento.size(); i++) {
                    eliminarEmpresa(testamento.get(i));
                }

                //Se borran los hijos dentro del componente y se elimina finalmente la empresa madre
                ((Empresa) componentes.get(indexOf(nit, "Empresa"))).eliminarTodas();
                eliminarEmpresa(((Empresa) componentes.get(indexOf(nit, "Empresa"))).getNIT());
            } else {
                //Si la empresa no tiene hijos pues solo se borra ella y ya
                componentes.remove(index);
            }
            exito = true;
        }
        return exito;
    }

    public boolean crearComposicionEmpresaEmpresa(String nitMadre, String nitHija) {
        boolean exito = false;
        Empresa empresaMadre = consultarEmpresa(nitMadre);
        Empresa empresaHija = consultarEmpresa(nitHija);

        if (empresaMadre != null && empresaHija != null) {
            empresaMadre.agregarComponente(empresaHija);
            exito = true;
        }
        return exito;
    }
    public boolean crearComposicionEmpresaEmpleado(String nit, String id) {
        boolean exito = false;
        if (consultarEmpresa(nit) != null && consultarBiciusuario(id) != null) {
            ((Empresa) componentes.get(indexOf(nit, "Empresa"))).agregarComponente(componentes.get(indexOf(id, "Biciusuario")));
            exito = true;
        }
        return exito;
    }
    public boolean eliminarComposicionEmpresaEmpleado(String nit, String id) {
        boolean exito = false;
        if (consultarEmpresa(nit) != null && consultarBiciusuario(id) != null) {
            ((Empresa) componentes.get(indexOf(nit, "Empresa"))).despedirEmpleado(((Biciusuario) componentes.get(indexOf(id, "Biciusuario"))).getId());
            exito = true;
        }

        return exito;
    }
    public boolean agregarBicicleta(String id, String serial, String marca, String color, String edad, String material) {
        int index = indexOf(id, "Biciusuario");

        if (index > -1) {
            Bicicleta bicicleta = new BicicletaImpl(serial, marca, color);

            if (!edad.equals(""))
                bicicleta = new EdadDecorator(bicicleta, edad);
            if (!material.equals(""))
                bicicleta = new MaterialDecorator(bicicleta, material);

            ((Biciusuario) componentes.get(index)).agregarBicicleta(bicicleta);
            return true;
        } else {
            System.out.println("El Id del biciusuario no existe");
            return false;
        }
    }

    private int indexOf(String identificador, String componente) {
        int index = -1;

        for (int i = 0; i < this.componentes.size(); i++) {
            if (componentes.get(i) instanceof Empresa) {
                if (componente.equals("Empresa")) {
                    if (identificador.equals(((Empresa) this.componentes.get(i)).getNIT())) {
                        index = i;
                    }
                }

            } else if (componentes.get(i) instanceof Biciusuario) {
                if (componente.equals("Biciusuario")) {
                    if (identificador.equals(((Biciusuario) this.componentes.get(i)).getId())) {
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }
}
