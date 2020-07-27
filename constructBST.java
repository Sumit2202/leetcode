

class Solution {
    //Definition for a binary tree node.
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder,int startIndexInorder, int endIndexInorder,int[] postorder, int                                    startIndexPostorder, int endIndexPostorder){
        if(startIndexInorder>endIndexInorder || startIndexPostorder>endIndexPostorder)
            return null;
        TreeNode root = new TreeNode(postorder[endIndexPostorder]);
        int ElementsBeforeRootInInorder = startIndexInorder;
        
        while(root.val!=inorder[ElementsBeforeRootInInorder])ElementsBeforeRootInInorder++;
        int countOfElementsBeforeRootInInorder = ElementsBeforeRootInInorder - startIndexInorder;
        
        root.left = helper(inorder,startIndexInorder,ElementsBeforeRootInInorder-1,postorder,
                          startIndexPostorder,startIndexPostorder+countOfElementsBeforeRootInInorder-1);
        
        root.right = helper(inorder,ElementsBeforeRootInInorder+1,endIndexInorder,postorder,
                           startIndexPostorder+countOfElementsBeforeRootInInorder,endIndexPostorder-1);
        
        return root;
    }
}