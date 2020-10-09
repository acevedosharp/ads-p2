package proxy;

import gestor.WrongNumberOfParamsException;

public interface GestorInteface {
    void ejecutarAccion(String accion) throws WrongNumberOfParamsException;
}
