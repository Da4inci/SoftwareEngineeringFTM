package org.hbrs.se1.ws21.uebung2.Main;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung2.MemberFactory;

public class Main {
    public static void main(String[] args) {
        Member m1 = MemberFactory.newMember(1);
        Member m2 = MemberFactory.newMember(2);
        Member m3 = MemberFactory.newMember(3);
        Member m4 = MemberFactory.newMember(4);
        Member m5 = MemberFactory.newMember(4);

        Member[] memberarray = {m1,m2,m3,m4};

        try {
            Container c1 = new Container();
            for (Member j : memberarray) {
                c1.addMember(j);
                System.out.println("Member " + j.getID() + " hinzugefügt");
            }
            c1.dump();
            System.out.println("size " + c1.size());
            System.out.println(c1.deleteMember(1));
            //System.out.println(c1.toString()); Funktioniert bei dem auskommentierten Teil: Container
            System.out.println("size " + c1.size());
            //System.out.println(m2.toString())
        }
        catch (ContainerException e){
            System.out.println(" ");

        }
    }
}
