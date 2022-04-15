// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(new Solution().majorityElement(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : a){
            if(!hm.containsKey(i))
                hm.put(i,1);
            else
                hm.replace(i, hm.get(i) +1);
        }

        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            if(e.getValue() > size/2)
                return e.getKey();
        }
        return -1;
    }
}