package org.hbrs.se1.ws21.uebung2.Test;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.CreateMember;
import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    Member m1;
    Member m2;
    Member m3;
    Member m4;

    @BeforeEach
    void setUp() {
        Container container = new Container();
        Member m1 = new CreateMember(1);
        Member m2 = new CreateMember(2);
        Member m3 = new CreateMember(3);
        Member m4 = new CreateMember(4);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test1() throws ContainerException {
        container.addMember(m1);
        assertThrows(ContainerException.class, () -> {
            container.addMember(m1);
        });
        assertTrue(container.contains(1));

        container.addMember(m2);
        assertThrows(ContainerException.class, () -> {
            container.addMember(m2);
        });
        assertTrue(container.contains(2));

        container.addMember(m3);
        assertThrows(ContainerException.class, () -> {
            container.addMember(m3);
        });
        assertTrue(container.contains(3));

        container.deleteMember(3);
        assertEquals("Löschen nicht möglich: Der Member mit der ID 3 existiert nicht.", container.deleteMember(3));
    }


}