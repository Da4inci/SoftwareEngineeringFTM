package org.hbrs.se1.ws21.uebung3.persistence;

import java.io.*;

import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    // URL of file, in which the objects are stored
    private String location = "/Users/finnthemachine/Desktop/membs2.txt";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException{
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("/Users/finnthemachine/Desktop/membs2.txt"));

            List<Member> newListe = member;
            objectOutputStream.writeObject(newListe);
            objectOutputStream.close();
        } catch(IOException e) {
            System.out.println("Fehler gefunden");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Member> load() throws PersistenceException {
        // Some Coding hints ;-)
        try {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        List<Member> newListe =  null;

        // Initiating the Stream (can also be moved to method openConnection()... ;-)
            fis = new FileInputStream( "/Users/finnthemachine/Desktop/membs2.txt" );
            ois = new ObjectInputStream(fis);
        //ObjectInputStream objectInputStream =
         //       new ObjectInputStream(new FileInputStream("Desktop/membs.txt"));
            Object obj = (List<Member>) ois.readObject();
            if (obj instanceof List<?>) {
                newListe = (List) obj;
            }
            ois.close();
        }
         catch (PersistenceException e) {      //Fängt auch alle unterklassen von PersistanceException ab
            System.out.println("The connection is not available");
        }
        return newListe;
        // Reading and extracting the list (try .. catch ommitted here)
    }
}
