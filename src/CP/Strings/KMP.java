package CP.Strings;

import java.util.Arrays;

//to find the number of occurrence of pat string in test string
/**
 * Concept used:LPS{the longest length of proper prefix which is also a proper suffix}
 *   a a a b a a a
 *   0 1 2 0 1 2 3
 *   every index indicates the size of lps if string ends there.
 */
public class KMP {
    public static void main(String[] args) {
        String test = "aabaabaab";
        String pat = "aabaabaab";
        String res = "aab#aabaabaab";
        int M = res.length();
        int[] lps = new int[M];
        computeLPSArray(res,M,lps);
        //No. of times lps arrays contains the pat.length() is the answer.
    }

    static void computeLPSArray(String pat, int M, int[] lps)
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lps));
    }
}
