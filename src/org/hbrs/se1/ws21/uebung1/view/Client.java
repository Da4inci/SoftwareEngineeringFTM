package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.Translator;
import org.hbrs.se1.ws21.uebung1.control.TranslatorFactory;

/**
 * author fwessl2s
 */

//Vorteile einer strengen implementierung des Interfaces) Flexible anpasspbarkeit

public class Client{

	private Translator translator;

	public Client(Translator t1) {
		translator = t1;
	}

	//Set translator
	public void setTranslator(Translator t1) {
		translator = t1;
	}
	// Methode zur Ausgabe einer Zahl auf der Console
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber
		// mit dem übergegebenen Wert der Variable aNumber
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		//Verwendung des DesignPattern: Factory Method(GoF), Kapitel6
		//Problem: Inkonsistenz Objekt Erzeugung
		//Lösung/Vorteil: konsistente und zentrale Erzeugung durch eine seperate Klasse Facotry
		Translator t = TranslatorFactory.createGermanTranslator(); //new GermanTranslator();
		String result = t.translateNumber(aNumber);

		System.out.println("Das Ergebnis der Berechnung: " + result);

	}

	public static void main(String[] args) {
		//Client c1 = new Client(10);
		//c1.display(10);
	}
}




