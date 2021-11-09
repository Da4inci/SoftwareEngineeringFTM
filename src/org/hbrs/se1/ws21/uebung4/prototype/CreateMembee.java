package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.Scanner;

public class CreateMembee implements Membee {

    int id;
    String Name;
    String Vorname;
    String Rolle;
    String Abteilung;
    String Expertise;

    public CreateMembee() {
        Scanner s = new Scanner(System.in);
        System.out.print("ID? ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("Vorname? ");
        String vn = s.nextLine();
        s.nextLine();
        System.out.print("Nachname? ");
        String nn = s.nextLine();
        System.out.print("Rolle? ");
        String rolle = s.nextLine();
        System.out.print("Abteilung? ");
        String abteilung = s.nextLine();
        System.out.print("Expertise? ");
        String expertise = s.nextLine();
    }

    @Override
    public Integer getID() {
        return id;
    }

    public String toString() {
        String s = "";
        s+= "Member (ID = " +getID() +")";
        return s;
    }
}
