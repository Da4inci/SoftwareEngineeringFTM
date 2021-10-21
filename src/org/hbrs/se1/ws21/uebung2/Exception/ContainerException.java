package org.hbrs.se1.ws21.uebung2.Exception;

public class ContainerException extends Exception{

    int id;

    //Geprüfte Exception: NullPointer Excpetion (während Laufzeit) +müssen abgefangen werden
    //Ungeprüfte Exception: Was von der eingabe entsteht +müssen nicht abgefangen werden

    public ContainerException(int id) {
        super("Das Member-Objekt mit der ID " +id +" ist bereits vorhanden!");
    }

    public ContainerException(String fehlermeldung) {
        super(fehlermeldung);
    }

}
