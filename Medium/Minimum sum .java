// { Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        // code here
        Arrays.sort(arr);
        int i=0, j=1;
        String n1 ="", n2="";
        while(i < n || j < n){
            if(i < n )
                n1 = n1 + arr[i];
            if(j < n)
                n2 = n2 + arr[j];
            i = i+2;
            j = j+2;
        }
        //System.out.println(n1 + " " + n2);

        int len = 0 ;//n1.length() < n2.length() ? n1.length() : n2.length();
        i =n1.length()-1; j=n2.length()-1;
        int carry =0;
        //StringBuilder sb = new StringBuilder();
        String res="";
        while(i >= 0 && j >= 0){
            int k = carry + (n1.charAt(i--) -'0') + (n2.charAt(j--) -'0') ;
            carry = k / 10;
            //sb = sb.append(k%10);
            res = res+ (k%10);
            //System.out.println(k);
        }

        while(i >= 0){
            int k = carry + (n1.charAt(i--) -'0');
            carry = k / 10;
            //sb = sb.append(k%10);
            res = res+ (k%10);
        }

        while(j >= 0){
            int k = carry + (n2.charAt(j--) -'0') ;
            carry = k / 10;
            // sb = sb.append(k%10);
            res = res+ (k%10);
        }
        //System.out.println(sb);
        if(carry != 0)
            // sb = sb.append(carry);
            res = res+ carry;
        StringBuilder sb = new StringBuilder(res);
        while(sb.charAt(sb.length()-1) == '0')
            sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
}
