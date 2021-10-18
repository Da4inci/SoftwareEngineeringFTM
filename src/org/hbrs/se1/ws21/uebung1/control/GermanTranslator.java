package org.hbrs.se1.ws21.uebung1.control;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * author fwessl2s
 */

public class GermanTranslator implements Translator {

	public String date = "Okt/2021"; // Default-Wert
	private HashMap<Integer, String> numberAsString;

	/**
	 * Methode zur Übersetzung einer Zahl als String Repraesentiert mithilfe eines
	 * Arrays als Datenstruktur
	 */
	public String translateNumber( int number ) {
		try {
			String[] name = {"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn"};
			return name[number-1];
		} catch (Exception IndexOutOfBounds) {
			//Wenn x <= 0 oder x> 10 dannn IndexOutOfBoundsException("Übersetzung der Zahl [übergebeneZahl] nicht möglich
			// ([Ausgabe der Versionsnummer des Translators aus Interface])“");
			return "Übersetzung der Zahl " + number + " nicht möglich" + " " + version;
		}
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2021))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
