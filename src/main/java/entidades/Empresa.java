package entidades;

import java.util.ArrayList;

public class Empresa extends AppUser implements Componente {

    private String nit;
    private ArrayList<Componente> componentes = new ArrayList<Componente>();

    public Empresa(String correo, String contrasena, String nombre, String direccion, String telefono, String nit) {
        super(correo, contrasena, nombre, direccion, telefono);
        this.nit = nit;
    }

    public String getNIT() {
        return nit;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }


    public void despedirEmpleado(String id) {
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i) instanceof Biciusuario) {
                if (((Biciusuario) componentes.get(i)).getId().equals(id)) {
                    componentes.remove(i);
                }
            }
        }
    }

    public void eliminarTodas() {
        componentes.clear();
    }


    @Override
    public void mostrarInformacion() {
        System.out.println(this.toString());

        if (componentes.size() > 0) {
            System.out.println("CONTIENE");
            for (Componente componente : componentes) {
                componente.mostrarInformacion();
            }
        }
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "NIT='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + contrasena + '\'' +
                '}';
    }
}
