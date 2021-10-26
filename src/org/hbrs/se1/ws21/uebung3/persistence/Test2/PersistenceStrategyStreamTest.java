package org.hbrs.se1.ws21.uebung3.persistence.Test2;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung2.MemberFactory;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceStrategyStreamTest {

    //Was ist denn das für ein komischer Test, anscheinend ist der leere Container bereits voll beim erstellen ...aaaahhhaaa ....
    Container container;
    List<Member> list;
    Member m1;
    Member m2;
    Member m3;
    Member m4;

    @BeforeEach
    void setup() {
        container = Container.getInstance();
        Member m1 = MemberFactory.newMember(1);

        try {
            container.addMember(m1);
        } catch (ContainerException e) {
            System.out.println("XXXXXFEEEEEHLER");
                    e.printStackTrace();
        }}

    /**
     * Prüft ob neuer Member in container gespeichert wurde sowohl vor dem saven als auch nach dem laden der neuen liste
     */
    @Test
    void save() {
        try {
            container.store();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        assertTrue(container.contains(1));

        container.deleteMember(1);
        Container c1 = Container.getInstance();
        try {
            c1.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        assertTrue(c1.contains(1));
        System.out.println("Test erfolgreich abgeschlossen");
    }

    @Test
    void verwendungderstrategiemongodb() {

    }

    @Test
    void closeConnection() {
    }

    @Test
    void load() {

       assertThrows(PersistenceException.class, () -> {
           container.addMember(m1);
        });
    }

}