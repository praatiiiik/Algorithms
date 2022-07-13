package CP.MATRIX;

//https://codeforces.com/contest/1703/problem/E

/*
 * Logic
 * When rotating a matrix
 * (i,j) -> 0 degree
 * (j,n-1-i) -> 90 degree
 * (n-1-i,n-1-j) -> 180 degree
 * (n-1-1j,i) -> 270 degree
 */

import java.util.Scanner;

public class RotatingGrid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            String [] arr = new String[n];
            for(int i =0; i<n; i++)
                arr[i] = sc.next();
            int res = 0;
            for(int i =0; i<n/2; i++) {
                for(int j = i; j<n-i-1; j++) {
                    int c = Integer.parseInt(arr[i].charAt(j)+"")
                            + Integer.parseInt(arr[j].charAt(n-i-1)+"")
                            + Integer.parseInt(arr[n-i-1].charAt(n-j-1)+"")
                            + Integer.parseInt(arr[n-j-1].charAt(i)+"");
                    c %= 4;
                    if(c==3) c=1;
                    res += c;
                }
            }
            System.out.println(res);
        }
    }
}
