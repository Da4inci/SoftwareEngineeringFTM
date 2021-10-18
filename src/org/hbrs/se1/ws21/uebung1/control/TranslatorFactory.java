package org.hbrs.se1.ws21.uebung1.control;

/**
 * author fwessl2s
 */
//Vorteile der Factory) <Erzeugung zentraler & konsostenter Objekte>
//Nachteile der Factory Pattern) <Extra Klasse, Komplexität>
public class TranslatorFactory {

    //Methode erzeugt ein neues GermanTrasnlator Objekt
    public static Translator createGermanTranslator() {

        //return new GermanTranslator();
        GermanTranslator translator = new GermanTranslator();
        translator.setDate("Okt/2021");
        return translator;
    }
}
