package i192015_A3;

import java.io.File;
import java.util.Scanner;


public class BinarySearchTree{

	public static class Node{  
		
	        String data;  
	        Node left;  
	        Node right;  
	  
	        public Node(String value){  
	        	
	            //Assign data to the new node, set left and right children to null  
	        	
	           data = value;  
	           left = null;  
	           right = null;  
	        }  
	      }  
	
	    public Node root;  
	    
	    public BinarySearchTree(){  
	        root = null;  
	    }  
	
	    //insert() will add new node to the binary search tree  
	    public void insert(String data) {  
	        //Create a new node  
	        Node node = new Node(data);  
	
	        //Check whether tree is empty  
	        if(root == null){  
	            root = node;  
	            return;  
	          }  
	        
	        else {  
	            //current node point to root of the tree  
	            Node temp = root, parent = null; 
	            while(true) {  
	                //parent keep track of the parent node of current node.  
	                parent = temp;  
	               
	                //If data is less than current's data, node will be inserted to the left of tree  
	                if(data.compareTo (temp.data) == -1) {  
	                    temp = temp.left;  
	                    if(temp == null) {  
	                        parent.left = node;  
	                        return;  
	                    }  
	                }  
	                //If data is greater than current's data, node will be inserted to the right of tree  
	                else {  
	                    temp = temp.right;  
	                    if(temp == null) {  
	                        parent.right = node;  
	                        return;  
	                    }  
	                }  
	                
	            }  
	            
	        }  
	        
	    }
	    public void inorderTraverse(Node node) {  
	    	  
	    
	        //Check whether tree is empty  
	        if(root == null){  
	            System.out.println("Tree is empty");  
	            return;  
	         }  
	        else {  
	
	            if(node.left!= null)  
	                inorderTraverse(node.left);  
	            System.out.print(node.data + "\n");  
	            if(node.right!= null)  
	                inorderTraverse(node.right);  
	
	        }  
	    }  
	    
	    boolean search(String key)  { 
	    	
	        Node r = search_Recursive(root, key); 
	        if (r!= null)
	            return true;
	        else
	            return false;
	    } 
	   
	    //recursive insert function
	    Node search_Recursive(Node root, String key)  { 
	        
	        if (root==null) {
	        	
	            return root; 
	        }
	        
	        if(root!=null && (root.data).compareTo(key)==0) {
	    		//System.out.println(root.data+" found "+key);
	
	            return root; 
	    	}
	        
	       
	        if ((root.data).compareTo(key)==1) 
	            return search_Recursive(root.left, key); 
	       
	        return search_Recursive(root.right, key); 
	        
	    }
}
