package entidades;

public class User
{
    protected String correo;
    protected String contrasena;

    public User(String correo, String password) {
        this.contrasena = password;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
