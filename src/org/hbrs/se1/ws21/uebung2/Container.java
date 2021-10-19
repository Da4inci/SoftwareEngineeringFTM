package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;

public class Container <T extends Member> {

    Member[] container;
    int size;
    int capacity;

    //Konstruktor erzeugt ein Objekt Container in denen Member angelegt werden können
    public Container() {
        size  = 0;
        container = (Member[]) new Object[capacity];
    }

    public int size() { return size; }

    public void addMember(Member m1) throws ContainerException {
        int i = 0;
        try {
            if(isIDinContainer(m1) == true) {
                throw new ContainerException(m1.getID());
            }
            if(size == capacity) {
                capacity*=2;
                Member[] container2 = (T[]) new Object[capacity];
                size= 0;
                for(Member j:container) {
                    container2[size++] =j;
                    container = container2;
                }
            } container[size] = m1;
            size++;
            //return container[size-1];
        }
        catch(ContainerException e) {
            System.out.print(e.toString());
        }
    }

    //prüft ob ID schon vorhanden ist
    public boolean isIDinContainer(Member m1) {
        int i = 0;
            while (container[i] != null) {
                if (container[i].getID() == m1.getID()) {
                    return true;
                }
                i++;
            } return false;
    }

    /**
     * Löscht den übergebenen Member aus dem Container
     * @param m1
     * @return
     */
    public String deleteMember(Member m1) throws ContainerException {
        int i = 0;
        try {
            if (isIDinContainer(m1) == true) {
                throw new ContainerException(m1.getID());
            }
            while (container[i] != null) {
                i++;
            }
        } finally {
            return "Member "+m1.getID() +"gelöscht";
        }
    }

    /**
     * Gibt die IDs der Members in dem gespeicherten Container aus
     */
    public void dump() {
        int i = 0;
        while(container[i] != null) {
            System.out.println(container[i]);
            i++;
        }
    }
}
