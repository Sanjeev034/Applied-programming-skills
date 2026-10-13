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
        TreeNode curr = root;
        
        while (curr != null) {
            // If both nodes are smaller than current node, move left
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // If both nodes are greater than current node, move right
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // We found the split point (or one of the nodes is current node)
            else {
                return curr;
            }
        }
        
        return null;
    }
}