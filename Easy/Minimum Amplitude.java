// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S1[] = read.readLine().split(" ");

            int[] A = new int[N];

            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.minAmplitude(A));

        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minAmplitude(int A[]) {
        //Code Here
        Arrays.sort(A);

        int max = Integer.MAX_VALUE;
        int s=0, e=A.length-1;

        max = Math.min(max, A[e] - A[s+3]);
        max = Math.min(max, A[e-2]- A[s+1]);
        max = Math.min(max, A[e-1] - A[s+2]);
        max = Math.min(max, A[e-3] - A[s]);

        return max;
    }
};