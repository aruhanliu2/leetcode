/* Tree, DFS, BFS, Recursion, Queue */
// My solution
// O(n)
// O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size > 0) {
                result.add(queue.peek().val);
            }
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return result;
    }
}
