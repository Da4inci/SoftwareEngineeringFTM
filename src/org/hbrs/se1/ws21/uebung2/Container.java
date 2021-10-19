package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;

public class Container implements Member{

    Container[] c1 = new Container[];

    //Konstruktor erzeugt ein Objekt Container in denen Member angelegt werden können
    public Container() {
        //Erstellt ein Array vom Typ Member
        Member[] container;
    }

    public int size() {
        while(c1 != null) {

        }
    }

    public void addMember(Member m1) throws ContainerException {
        int i = 0;
        try {
            if(c1.isIDinContainer(m1) == true) {
                throw new ContainerException();
            }
            while (container[i] != null) {
                i++;
            }
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
            if(c1.isIDinContainer(m1) == true) {
                throw new ContainerException();
            }
            while (c1.container[i] != null) {
                i++;
            }
        }
    }

    /**
     * Gibt die IDs der Members in dem gespeicherten Container aus
     */
    public void dump() {
        int i = 0;
        while(container[i] != null) {
            container[i].getID().toString();
        }
    }

    public String toString() {
        String s = "";
        int i = 0;
        while(container[i] != null) {
            System.out.println("Member (ID = " +container[i].getID() +")");
        }
        return s;
    }

    @Override
    public Integer getID() {
        return null;
    }
}
