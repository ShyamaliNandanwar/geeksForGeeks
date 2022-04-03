// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] a, int n, int s)
    {
        // Your code here
        int sumSoFar = 0, i=0, j=0;
        while(j < n && sumSoFar < s){
            sumSoFar = sumSoFar + a[j];
            while(sumSoFar > s){
                sumSoFar = sumSoFar - a[i];
                i++;
            }
            j++;
        }
        return sumSoFar == s ? new ArrayList<>(Arrays.asList(i+1,j)) : new ArrayList<>(Arrays.asList(-1));
    }
}