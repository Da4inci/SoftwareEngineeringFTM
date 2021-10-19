package org.hbrs.se1.ws21.uebung2;


public class MemberFactory{

    public static Member newMember(int id) {
        CreateMember m1 = new CreateMember(id);
        return m1;
    }

}
