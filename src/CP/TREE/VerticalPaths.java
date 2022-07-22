package CP.TREE;

//https://codeforces.com/problemset/problem/1675/D

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class VerticalPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] storeParent = new int[n + 1];
            Arrays.fill(storeParent, -1);
            int[] hasChild = new int[n + 1];
            Arrays.fill(hasChild, -1);
            int count = 0;
            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt();
                if (i != x && hasChild[x] == -1) {
                    storeParent[i] = x;  //storing parent of ith element
                    hasChild[x] = i;     //storing that only one child of parent
                } else count++;
            }
            System.out.println(count);
            for (int i = 1; i <= n; i++) {
                if (hasChild[i] == -1) {
                    int k = 0;
                    ArrayList<Integer> al = new ArrayList<>();
                    for (int j = i; j != -1; j = storeParent[j]) {
                        k++;
                        al.add(j);
                    }
                    System.out.println(k);
                    Collections.reverse(al);
                    for (int j : al) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void fun(Scanner sc) {
        int n = sc.nextInt();
        int[] pp = new int[n];
        Arrays.fill(pp, -1);
        int[] qq = new int[n];
        Arrays.fill(qq, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt() - 1;
            if (p != i && qq[p] == -1) {
                pp[i] = p;
                qq[p] = i;
            } else
                cnt++;
        }
        System.out.println(cnt);
        for (int i = 0; i < n; i++)
            if (pp[i] == -1) {
                int k = 0;
                for (int j = i; j != -1; j = qq[j])
                    k++;
                System.out.println(k);
                for (int j = i; j != -1; j = qq[j])
                    System.out.print(j + 1 + " ");
                System.out.println();
            }
    }
}



/*
 * Intution
 * we have to print minimum paths,
 *   -> minimum paths would be equal to no. of leaf nodes in tree
 *   -> if num not given in input array ,it means they are not parent of anyone, therefore mark them as -1
 *   -> now we have leaf nodes
 *   -> take leaf node and print there parents in reverse order , that would be the path.
 */
