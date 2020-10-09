package entidades;

public class Admin extends User implements Componente {

    public Admin(String correo, String password) {
        super(correo, password);
    }


    @Override
    public void mostrarInformacion() {

    }
}
