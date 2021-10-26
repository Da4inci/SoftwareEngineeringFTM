package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.Iterator;
import java.util.LinkedList;

public class MemberView {

    public static void dump(LinkedList<Member> list) {

        Iterator<Member> listIterator = list.iterator();
        Member tempMember;
        while (listIterator.hasNext()) {
            tempMember = listIterator.next();
            System.out.println(tempMember.toString());
        }
    }
}
