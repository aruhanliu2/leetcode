/* Tree, DFS */
// My solution
// O(n)
// O(logn)
class Solution {
    public int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(Integer.MIN_VALUE, root);
        return count;
    }
    public void dfs(int max, TreeNode root) {
        if(root == null) return;
        if(max <= root.val) {
            count++;
            max = Math.max(max,root.val);
        }
        dfs(max,root.left);
        dfs(max,root.right);
    } 
}
