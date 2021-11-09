package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.Scanner;

public class Eingabe {

    public static void enter() {
        Scanner sc = new Scanner(System.in);
         String befehl = sc.next();
                switch(befehl) {
                    case "enter":
                        System.out.println("Finance");
                        break;
                    case "store":
                        System.out.println("Sales");
                        break;
                    case "loadforce":
                        System.out.println("Production");
                        break;
                    case "loadmerge":
                        System.out.println("Marketing");
                        break;
                    case "dump":
                        System.out.println("Operations");
                        break;
                    case "exit":
                        System.out.println("Operations");
                        break;
                    case "help":
                        System.out.println("Operations");
                        break;
                    default:
                        System.out.println("Unguilty Command!");
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
