package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.Exception.ContainerException;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung2.MemberFactory;
/*
@author fwessl2s
 */
public class Client {

    public static void SilverMen() {

        Container c1 = Container.getInstance();
        Member sabatschus = MemberFactory.newMember(1);
        Member frodeno = MemberFactory.newMember(2);
        Member hogenhaug = MemberFactory.newMember(3);

        try {
            c1.addMember(sabatschus);
            c1.addMember(frodeno);
            c1.addMember(hogenhaug);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    MemberView.dump(c1.getCurrentList());
    }
}
