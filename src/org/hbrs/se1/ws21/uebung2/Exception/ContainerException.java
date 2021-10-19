package org.hbrs.se1.ws21.uebung2.Exception;

public class ContainerException extends Exception{
    public ContainerException() {
        super("Das Member-Objekt mit der ID  ist be- reits vorhanden!");
    }
    public ContainerException(String fehlermeldung) {
        super(fehlermeldung);
    }

}
