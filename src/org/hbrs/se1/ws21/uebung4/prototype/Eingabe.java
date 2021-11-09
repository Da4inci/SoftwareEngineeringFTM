package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.Scanner;

public class Eingabe {

    Container cont = new Container();

    public static void enter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eingabe starten: ");
        while(sc.hasNext()) {
            String befehl = sc.next();
            switch (befehl) {
                case "enter":
                    CreateMembee c1 = new CreateMembee();
                    cont.addEmployee();
                    System.out.println("Member was created");
                    break;
                case "store":
                    System.out.println("Member was saved");
                    break;
                case "loadforce":
                    System.out.println("Memberlist was loaded");
                    break;
                case "loadmerge":
                    System.out.println("Memberlist was loaded");
                    break;
                case "dump":
                    System.out.println("Member list was shown");
                    break;
                case "exit":
                    System.out.println("See you again");
                    sc.close();
                    break;
                case "help":
                    System.out.println("You can use following Commands: \n" +
                            "*enter(to create a new worker) \n" +
                            "*store(save all member objects persistence in your data) \n" +
                            "*load(load all members from your data) \n" +
                            "*dump(show all saved members) \n" +
                            "*exit(leave this shitty programm) \n" +
                            "*help(show this again)");
                    break;
                default:
                    System.out.println("Unguilty Command!");
            }
            //befehl += sc.nextLine();
        }
            }

    public static void store() {

    }

    public static void load() {

    }

    public static void dump() {

    }

    public static void search() {

    }

    public static void exit() {

    }

    public static void help() {

    }



}
