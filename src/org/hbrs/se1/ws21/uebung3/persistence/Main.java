package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung2.MemberFactory;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {

            Member m1 = MemberFactory.newMember(1);
            Member m2 = MemberFactory.newMember(2);
            Member m3 = MemberFactory.newMember(3);
            Member m4 = MemberFactory.newMember(4);
            //Member m5 = MemberFactory.newMember(4);

            Member[] memberarray = {m1,m2,m3,m4};
            Container c1 = Container.getInstance();

            try {
                for (Member j : memberarray) {
                    c1.addMember(j);
                    System.out.println("Member " + j.getID() + " hinzugefügt");
                }
                c1.store();
            }
            catch (PersistenceException | ContainerException e){
                System.out.println("Fehler");

            }
    /*

             Container c1 = Container.getInstance();

            try {
                c1.load();
            }
            catch (PersistenceException e){
                System.out.println("Fehler");
            }
            System.out.println(c1.list.toString());

    */
    }


}
