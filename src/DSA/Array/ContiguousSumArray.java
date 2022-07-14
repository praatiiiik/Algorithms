package DSA.Array;

public class ContiguousSumArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int n = array.length;

        int[] sumArray = new int[n+1];
        sumArray[0] = 0;
        sumArray[1] = array[0];

        for(int i=2;i<=n;i++){
            sumArray[i] = sumArray[i-1] + array[i-1];
        }

        //Now sum of all the contiguous subArray would be

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int x = sumArray[j] - sumArray[i - 1];
                System.out.println(x);
            }
        }
    }
}

/*
Meaning : To find sum of all Contiguous Subarray.
Method : Make a prefix sum array
  eg: arr[] =  1,2,3,4,5
  sumArray[] = 0,1,3,6,10,15
  We can find sum of contiguous subarray from index i to j as sum[j]-sum[i-1]
Intution: For example there are 3 people name a,b,c
          a gives me 1, b gives me 2, c gives 3
          now sumArray[] would be 0,1,3,6
          Now, if i want to know how much money is given by b and c
          i just subtract the value of sumArray[1] from sumArray[4]
          , Now i get 5, which is given by b and c.
 */
