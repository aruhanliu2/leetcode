// BFS, DFS, Union Find
// My Solution: DFS
// O(MN), O(MN)
class Solution {
    public int numIslands(char[][] grid) {
        //判断valid input
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}

// My solution: BFS
// O(MN), O(min(M,N) - 最差的情况，全部grid为1，queue最多装一个边长的grid，因为他随时都在pop，所以不可能有同时所有的grid在queue里的情况。
class Solution {
    public int numIslands(char[][] grid) {
        //判断valid input
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                queue.add(new int[]{i, j});
                grid[i][j] = '0'; //标记走过
                while (!queue.isEmpty()) {
                    int[] pair = queue.poll(); //Queue的方法
                    for (int k = 0; k < 4; k++) {
                        int x = pair[0] + dirX[k];
                        int y = pair[1] + dirY[k];
                        if (x < 0 || y < 0
                            || x >= grid.length || y >= grid[0].length
                            || grid[x][y] == '0') {
                            continue;
                        }
                        queue.add(new int[]{x,y});
                        grid[x][y] = '0'; //标记走过
                    }
                }
                num++;
            }
        }
        return num;
    }
}
