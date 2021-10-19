package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;

public class Container {

    Member[] container;
    int size= 0;
    int capacity = 1;

    //Konstruktor erzeugt ein Objekt Container in denen Member angelegt werden können
    public Container() {
        container = new Member[capacity];
    }

    public int size() { return size; }

    public void addMember(Member m1) throws ContainerException {
        int i = 0;
        try {
            if(size != 0) {
                if (isIDinContainer(m1) == true) {
                    throw new ContainerException(m1.getID());
                }
            }
            if(size == capacity) {
                capacity*=2;
                Member[] container2 = new Member[capacity];
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
            for(int z = 0; z<size; z++){
                if (container[z].getID() == m1.getID()) {
                    return true;
                }
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
            if (isIDinContainer(m1) == false) {
                throw new ContainerException(m1.getID());
            }
           while(container[i]!= m1) {
               i++;
           } while(container[i] != null) {
               container[i] = container[i+1];
               i++;
            }
        } finally {
            container[size-1] = null;
            return "Member ID: "+m1.getID() +" gelöscht";
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

    public String toString() {
        String s = "";
        int i = 0;
        while(i < size) {
            s += "\n"+container[i];
            i++;
        } return s;
    }
}
