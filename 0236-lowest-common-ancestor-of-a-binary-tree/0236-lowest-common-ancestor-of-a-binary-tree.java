/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the current node is null, or matches either p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively search the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right return non-null, p and q are in different subtrees
        // This means the current root is their lowest common ancestor
        if (left != null && right != null) {
            return root;
        }
        
        // If only one subtree returns a node, both p and q are located in that subtree
        return left != null ? left : right;
    }
}