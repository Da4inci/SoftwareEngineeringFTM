package org.hbrs.se1.ws21.uebung2;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceStrategyStream;

//Herr Alda ich muss sagen, dass ich die Letzte Aufagbenstellung bezüglich der Datenstruktur ANFORDERUNG
// erst am Ende nach der Bearbeitung des eigentlichen Programms gelesen habe, demnach finden sie unter dem neuen
// (jetzigen) Programm die eigentlichen Methoden(kommentiert) ...schade, aber dennoch war das eine gute Übung :)


public class Container {

    public LinkedList<Member> list;
    /**
     * Privates Klassenattribut,
     * wird beim erstmaligen Gebrauch der Klasse erzeugt
     * Direkte Instanzieerung beim Laden der Klasse -> Hoher Speicherbedarf
     * private final static Container container = new Container();
     */
    private static Container container;

    /*
    private final static Object lock = new Object();
    public static Container getINstance() {
        synchronized (lock) {
            if (instance == null) {
                return instance;
            }
        }
        return instance;
        }
     */

    /** Konstruktor ist privat, darf nicht von außen instanziiert werden. */
    private Container() {
        list = new LinkedList<>();
    }

    //LazyCreation
    //Von Lazy Creation spricht man, wenn das einzige Objekt der Klasse erst erzeugt wird, wenn es benötigt wird.
    //Ziel ist, dass der Speicherbedarf und die Rechenzeit für die Instanziierung des Objektes nur dann aufgewendet werden, wenn das Objekt wirklich benötigt wird.
    //Hierzu wird der Konstruktor ausschließlich beim ersten Aufruf der Funktion getInstance() aufgerufen.

    //Design Pattern: Singleton
    /**
     * Statische Methode "getInstance()" liefert die einzige Instanz der Klasse zurück.
     * synchronisiert und somit thread-sicher. Thread = Teilprozess
     *
     */
    public synchronized static Container getInstance() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    public void addMember(Member member) throws ContainerException {
        if(this.contains(member.getID())) {
            String e = "Das Member-Objekt mit der ID " +member.getID() +" ist bereits vorhanden!";
            throw new ContainerException(e);
        }
        list.add(member);
    }

    /**
     * Überprüft ob ein Member schon vorhandne ist
     * @param id
     * @return
     */
    public boolean contains(int id) {
        Iterator<Member> listIterator = list.iterator();
        Member tempMember;
        while (listIterator.hasNext()) {
            tempMember = listIterator.next();
            if(tempMember.getID() == id) {
                return true;
            }
        }
        return false;
    }
    public String deleteMember(int id) {
        if(this.contains(id) == false) {
            return "Löschen nicht möglich: Der Member mit der ID " +id +" existiert nicht.";
        }
        else {
            Iterator<Member> listIterator = list.iterator();
            Member tempMember;
            while (listIterator.hasNext()) {
                tempMember = listIterator.next();
                if(tempMember.getID() == id) {
                    list.remove(tempMember);
                    break;
                }
            }
            return "Erfolgreich gelöscht: Der Member mit der ID " +id +" wurde entfernt.";
        }
    }

    public LinkedList<Member> getCurrentList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    /**
     * Ruft die Methode store über den stream auf
     * @throws PersistenceException
     */
    public void store() throws PersistenceException {
        PersistenceStrategyStream stream1 = new PersistenceStrategyStream();
        stream1.save(list);
    }

    /**
     * Ruft die Methode load über den stream auf
     */
    public void load() throws PersistenceException {
        PersistenceStrategyStream stream2 = new PersistenceStrategyStream();
        list = (LinkedList<Member>) stream2.load();
    }


}

/*    Member[] container;
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
     //
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
    */

