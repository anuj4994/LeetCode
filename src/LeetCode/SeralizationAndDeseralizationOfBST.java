/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LeetCode;

import java.util.Stack;

/**
 *
 * @author Anuj Shah
 */
public class SeralizationAndDeseralizationOfBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
        SeralizationAndDeseralizationOfBST ser = new SeralizationAndDeseralizationOfBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        ser.deserialize(ser.serialize(root));
        printInOrder(root);
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) {
            
            return;
        }
       
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);    
    }
    
   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String serData = "";
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while(true){
            if(current != null){
                if(current.right != null) {
                    stack.push(current.right);
                }
                stack.push(current);
                current = current.left;
                continue;
            }
            if(stack.isEmpty()){
                System.out.println("serdeta ::" + serData);
                return serData;
            }
            current = stack.pop();
            if(current.right != null && !stack.isEmpty() && current.right == stack.peek()){
                stack.pop();
                stack.push(current);
                current = current.right;
            } else {
                if(serData.equals("")){
                    serData = serData + current.val;
                } else {
                    serData = serData + "," + current.val;
                }
               current = null;
            }
        }
        
    }
    
   
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String dataArray[] = data.split(",");
        int size = dataArray.length;
        int dataIntArray[] = new int[size];
        for(int i = 0 ; i < size ; i++){
            dataIntArray[i] = Integer.parseInt(dataArray[i]);
        }
        TreeNode root = new TreeNode(dataIntArray[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        for(int i = 1 ; i < size ;i++){
            TreeNode temp = null;
            while(!stack.isEmpty() && dataIntArray[i] > stack.peek().val ){
                temp = stack.pop();
            }
            if(temp != null ){
                temp.right = new TreeNode(dataIntArray[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new TreeNode(dataIntArray[i]); 
                stack.push(temp.left);
            }
        }
        return root;
    }

    
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
