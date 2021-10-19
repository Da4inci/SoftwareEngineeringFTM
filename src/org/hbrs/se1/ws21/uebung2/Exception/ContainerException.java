package org.hbrs.se1.ws21.uebung2.Exception;

public class ContainerException extends Exception{

    int id;

    public ContainerException(int id) {
        super("Das Member-Objekt mit der ID" +id +"ist be- reits vorhanden!");
    }

    //public ContainerException(String fehlermeldung) {
    //    super(fehlermeldung);
    //}

}
