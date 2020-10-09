package entidades;

import decorator.Bicicleta;

import java.util.ArrayList;

public class Biciusuario extends AppUser implements Componente {

    private String id;

    private ArrayList <Bicicleta> bicicletas = new ArrayList<Bicicleta>();

    public Biciusuario(String correo, String password, String nombre, String direccion, String telefono, String id) {
        super(correo, password, nombre, direccion, telefono);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void agregarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
    }

    public ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(this.toString());

        for(Bicicleta bicicleta:bicicletas){
            bicicleta.mostrarInformacion();
        }
    }

    @Override
    public String toString() {
        return "Biciusuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + contrasena + '\'' +
                '}';
    }
}
