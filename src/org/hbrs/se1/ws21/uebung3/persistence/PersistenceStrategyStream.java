package org.hbrs.se1.ws21.uebung3.persistence;

import java.io.*;

import java.util.List;

import static org.hbrs.se1.ws21.uebung3.persistence.PersistenceException.ExceptionType.ImplementationNotAvailable;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    ObjectInputStream ois = null;
    FileInputStream fis = null;
    List<Member> newListe =  null;

    // URL of file, in which the objects are stored
    private String location = "/Users/finnthemachine/Desktop/membs3.txt";

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
        try {
            fis = new FileInputStream(location);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            ois.close();
        } catch (IOException e) {
            System.out.println("File not Closed");
            //e.printStackTrace();
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException{
        try {
            FileOutputStream fos = new FileOutputStream(location);
            ObjectOutputStream ous = new ObjectOutputStream(fos);

            System.out.println(member);
            List<Member> newListe = member;
            ous.writeObject(member);
            ous.close();
        } catch(IOException e) {
            throw new PersistenceException(ImplementationNotAvailable, "");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     * Rückgabewert: List<Member>
     */
    public List<Member> load() throws PersistenceException {
        Object obj = null;
        try {
            openConnection();           // Initiating the Stream
            obj = (List<Member>) ois.readObject();
            closeConnection();
        }
         catch (IOException | ClassNotFoundException e) {      //Fängt auch alle unterklassen von PersistanceException ab
            System.out.println("The connection is not available");
        }
        if (obj instanceof List<?>) {
            newListe = (List) obj;
            return newListe;
        }
        // Reading and extracting the list (try .. catch ommitted here)
        return null;
    }
}
