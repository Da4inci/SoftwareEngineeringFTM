package org.hbrs.se1.ws21.uebung1.Test;

import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author fwessl2s
 */

class GermanTranslatorTest {

    GermanTranslator g1;

    @BeforeEach
    void setup() {
        g1 = new GermanTranslator();
    }


    /**
     * Dieser Test prüft ob jeweils die richtige lexikalische Übersetzung von der eingebebene Nummer
     * ausgegeben wird...
     */
    @Test
    void ausgabeTest() {
        //Testet die gÄK_1 in dem Definitionsbereichh 0<x<11
        assertEquals("zwei", g1.translateNumber(2), "gÄK ist ungültig");
        assertEquals("fünf", g1.translateNumber(5), "gÄK ist ungültig");
        assertEquals("zehn", g1.translateNumber(10), "gÄK ist ungültig");

        //Testen von uÄK_2 in dem Defitionsbereich x<0
        assertEquals("Übersetzung der Zahl -1 nicht möglich 1.0", g1.translateNumber(-1), "gÄK ist ungültig");

        //Testen von uÄK_3 in dem Defintionsbereich x>10
        assertEquals("Übersetzung der Zahl 11 nicht möglich 1.0", g1.translateNumber(11), "gÄK ist ungültig");
    }
}
