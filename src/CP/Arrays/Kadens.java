package CP.Arrays;

public class Kadens {
    /**
     * Find the contiguous sub-array(containing at least one number) which has the maximum sum
     */
    public static void main(String[] args) {
        int[] arr = {2,-1,4,3,5,};
        int n = arr.length;
        long sum=0;
        long max=0;
        for (int j : arr) {
            sum = sum + j;
            sum = Math.max(sum, 0);
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
