package org.hbrs.se1.ws21.uebung4.prototype;

public class BubbleSort {

        public static void BubbleSort(Container c){
            int [] a = {};
            for(int i = 0; i < c.size(); i++) {
            }
            int i = 0;
            System.out.println(java.util.Arrays.toString(a));
            for (int z = 0; z < a.length; z++) {
                for(int ii = 0; ii < a.length-1; ii++) {
                    if(a[i] > a[i+1]) {
                        int s1 = a[i+1];
                        a[i+1] = a[i];
                        a[i] = s1;
                    } i++;
                }
                System.out.println(java.util.Arrays.toString(a));
                i = 0;
            }
        }

    }
