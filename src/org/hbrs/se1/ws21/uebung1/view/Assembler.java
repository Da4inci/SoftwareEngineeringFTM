package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws21.uebung1.control.Translator;

public class Assembler {
    public void main() {
        //Verwendung des Dependency Injection(DI) Pattern
        Translator translator = new GermanTranslator();
        Client client = new Client(translator);
        client.setTranslator(new GermanTranslator());
    }
}