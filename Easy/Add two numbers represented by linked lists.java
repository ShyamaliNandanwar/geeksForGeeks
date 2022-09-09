// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{

    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list

        Node ans = new Node(0);
        Node head = ans;

        first = reverse(first);

        second = reverse(second);

        int carry = 0;
        while(first!=null && second != null){
            int n = first.data + second.data + carry;
            carry = 0;
            if(n > 9){
                carry = n / 10;
                n = n % 10;
            }
            ans.next = new Node(n);
            ans = ans.next;
            first = first.next;
            second = second.next;
        }

        while(first!=null){
            int n = first.data + carry;
            carry = 0;
            if(n > 9){
                carry = n / 10;
                n = n % 10;
            }
            ans.next = new Node(n);
            ans = ans.next;

            first = first.next;
        }
        while(second!=null){
            int n = second.data + carry;
            carry = 0;
            if(n > 9){
                carry = n / 10;
                n = n % 10;
            }
            ans.next = new Node(n);
            ans = ans.next;
            second = second.next;
        }

        if(carry > 0){
            ans.next = new Node(carry);
            ans = ans.next;
        }

        Node rev = reverse(head.next);

        return rev;
    }

    static Node reverse(Node node){
        if(node==null)
            return node;
        Node prev = null;

        Node curr = node;
        Node next = null;

        while(curr != null){
            next =  curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}