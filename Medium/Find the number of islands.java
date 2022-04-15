// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int count=0;
        int r= grid.length;
        int c= grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char n[][], int r, int c){
        if(r < 0 || r > n.length-1 || c <0 || c > n[0].length-1 || n[r][c]!='1')
            return;

        n[r][c] = '#';
        dfs(n, r+1, c);
        dfs(n, r-1, c);
        dfs(n, r, c+1);
        dfs(n, r, c-1);
        dfs(n, r+1, c+1);
        dfs(n, r-1, c-1);
        dfs(n, r-1, c+1);
        dfs(n, r+1, c-1);

    }
}