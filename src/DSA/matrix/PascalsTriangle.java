package DSA.matrix;

import java.util.ArrayList;

public class PascalsTriangle {
    public static void main(String[] args) {

    }

    //find pascal's triangle till level n
    private static void findPascalTriangle(int n) {
        ArrayList<ArrayList<Long>> al = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> l1 = new ArrayList<Long>();
        l1.add(1L);
        al.add(l1);

        for (int i = 1; i < n; i++) {
            ArrayList<Long> l = new ArrayList<>();
            l.add(1L);
            for (int j = 1; j <= i - 1; j++) {
                l.add(al.get(i - 1).get(j - 1) + al.get(i - 1).get(j));
            }
            l.add(1L);
            al.add(l);
        }
        System.out.println(al);
    }

    //find value of [row][column] in pascal's triangle

    /**
     * formula for getting value is
     * (r-1)C(c-1)
     *
     * @param n total level
     * @param r ith row
     * @param c jth column
     */
    private static void findValue(int n, int r, int c){

    }

    /**
     *
     *  To print rth row
     *  find all the values of (r-1)C(c-1) for c=0 to c=r;
     *  To find the value of r in optimized way , or to find combination of row in optimized way, let r = 4,
     *
     *  for c = 0 -> 1
     *  for c = 1 -> 4/1
     *  for c = 2 -> 4*3/1*2
     *  for c = 3 -> 4*3*2 and so on
     *
     * @param r print rth row of pascals triangle
     */
    public static void findRow(int r){

    }
}
