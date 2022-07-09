package CP.Strings;

import java.util.Arrays;

/**
 * It's like KMP
 * Pattern Matching Algo
 * First position of z[] is always 0
 *     a a a b a a a
 *     0 1 2 0 1 2 3
 */
public class ZAlgo {
    public static void main(String[] args) {
        String s = "ababadababae";
        int n = s.length();
        int[] z = new int[n];
        bruteForceZFun(s,z,n);
    }

    static void bruteForceZFun(String s,int[] z,int n){
        for(int i=1;i<n;i++){
            while (s.charAt(z[i])==s.charAt(i+z[i])){
                z[i]++;
            }
        }
        System.out.println(Arrays.toString(z));
    }
}