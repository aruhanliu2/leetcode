// Refer to this website for more solutions, here I only pick one BFS and DFS solutions.
// https://leetcode.com/problems/binary-tree-right-side-view/solution/

/* Tree, DFS, BFS, Recursion, Queue */
// My solution
// O(n)
// O(D): D is the diameter of the tree. In the worst case complete tree, D < N
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

// Approach 4: Recursive DFS
// Time complexity: O(N) since one has to visit each node.
// Space complexity: O(H) to keep the recursion stack, where HH is a tree height. The worst-case situation is a skewed tree, when H=N.
class Solution {
    List<Integer> rightside = new ArrayList();
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
}
