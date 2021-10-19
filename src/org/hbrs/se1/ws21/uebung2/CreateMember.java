package org.hbrs.se1.ws21.uebung2;

public class CreateMember implements Member{

    int id;

    public CreateMember(int id) {
        this.id = id;
    }

    @Override
    public Integer getID() {
        return null;
    }

    public String toString() {
        String s = "";
        s+= "Member (ID = " +getID() +")";
        return s;
    }
}
