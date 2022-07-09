package DSA.dp;

import java.util.Arrays;

public class UniquePaths {


    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return spaceOptimization(m, n);
    }

    /**
     * in space optimization
     * the answer is being stored in the previous value of i and up value of i. so we make array of up value and save previous value in prev and updaet
     * prev
     */
    static int spaceOptimization(int m, int n) {
        if (n == 1) return 1;
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int prev = 1;
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j] + prev;
                prev = arr[j];
            }
        }
        return arr[n - 1];
    }

    /**
     * in tabulation,
     * we know the answer is being stored of i in [i-1][j](up) and [i][j-1](left)
     * so we add only these two with base case as dp[0][0]==1
     */
    static int tabulation(int m, int n, int[][] dp) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //base condition
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];

    }

    /**
     * In this function
     * we go to [i+1][j](down) and [i][j+1] (forward) and calculate the answer
     */
    private static int memoization(int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int a = memoization(m, n, i + 1, j, dp);
        int b = memoization(m, n, i, j + 1, dp);
        return dp[i][j] = (a + b);
    }
}

