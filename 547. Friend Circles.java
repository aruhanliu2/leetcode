// Depth First Search
// My solution
// 答案：https://leetcode.com/problems/friend-circles/solution/
class Solution {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.numComponents;
    }
    
    public class UnionFind {
        int size = 0;
        int[] parent;
        int numComponents;
        public UnionFind(int size) {
            this.size = size;
            this.numComponents = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int child) {
            if (parent[child] != child) {
                parent[child] = this.find(parent[child]);
            }
            return parent[child];
        }
        
        public void union(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) {
                return;
            }
            parent[root1] = root2;
            numComponents--;
        }
    }
}
