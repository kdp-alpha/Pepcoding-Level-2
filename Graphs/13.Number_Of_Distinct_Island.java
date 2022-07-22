//https://www.lintcode.com/problem/860/
public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public static StringBuilder sb = new StringBuilder();
    public void dfs(int[][] grid,int r,int c){
        grid[r][c] = 0;
        if(r-1>=0 && grid[r-1][c]==1){
            sb.append("u");
            dfs(grid,r-1,c);
        }
        if(r+1 < grid.length && grid[r+1][c]==1){
            sb.append("d");
            dfs(grid,r+1,c);
        }
        if(c-1 >= 0 && grid[r][c-1]==1){
            sb.append("l");
            dfs(grid,r,c-1);
        }
        if(c+1<grid[0].length && grid[r][c+1]==1){
            sb.append("r");
            dfs(grid,r,c+1);
        }
        sb.append("z");
    }


    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        int n = grid.length;
        int m = grid[0].length;
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    sb = new StringBuilder();
                    sb.append("x");
                    dfs(grid,i,j);
                    
                    hs.add(sb.toString());
                }
            }
        }
        return hs.size();
    }
}
