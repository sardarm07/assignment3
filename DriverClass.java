package i192015_A3;

import java.util.ArrayList;
import java.util.Vector;
import java.lang.Thread;
import java.util.Scanner;
import java.io.File;

public class DriverClass {
	
	static  BinarySearchTree b = new  BinarySearchTree();
	static ArrayList<word> w = new ArrayList<word>();
	static Vector<String> vector = new Vector<String>(); 
	static ArrayList<input1> in;
	static vocabulary vocal;
	
	public static void main(String[] args) {  
		
			int j=0,i=0,x=args.length;
			vocal = new vocabulary(args[0]);
			in = new ArrayList<input1>();
			
			while(i<x)
			{
				if(i==0)
				{
					vocal.setName(args[0]);  
					vocal.start();   
				}
				
				else 
				{
					in.add(i-1,new input1(args[i]));
					in.get(i-1).setName(args[i]);
					in.get(i-1).start();
				}
				
				i++;
			}
			
			try {
				
				vocal.join();
				
			} catch (InterruptedException e) {
				
										// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	         while(j < x-1)
	         {
	        	 try {
	        		 
					in.get(j).join();
					j++;
					
				} catch (InterruptedException e) {
										// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	 
	         }
	    
	    while(true) {
	    	menu(args);
	    }
		
		
	}
	
	static void menu(String[] args) {
		
		System.out.println("1. Displaying BST build from Vocabulary File.");
		System.out.println("2. Displaying Vectors build from Input files.");
		System.out.println("3. Viewing Match words and its frequency.");
		System.out.println("4. Search a query");
		System.out.println("5. Enter 5 for Exit.");
		
		 Scanner s=new Scanner (System.in);
		 int opt=s.nextInt();
		    
		if(opt==1) {
			b.inorderTraverse(b.root);
		}
		
		else if(opt==2) {
			
			System.out.println("Vectors: " + vector);
		}
		
		else if(opt==3) {
			
			word wd=new word();
	    	for(int i=0;i < w.size(); i++) {
	    		
	    		wd.Printword(i);
	    	}
		}
		
		else if(opt==4) {
			
			Scanner scan= new Scanner(System.in); 
			System.out.print("Enter query: ");  
			String query= scan.nextLine();        
			
			int len=query.length();
			
			String[] words=query.split("\\s");	//splits the string based on whitespace  
			
			 boolean flag = false;
		     int count = 0;
		     boolean found = false;
		      
		     
			for(String w:words){  
			
				File file = new File(args[0]);
			    Scanner sc2 = new Scanner(args[0]);

		    
		      while(sc2.hasNextLine()) {
		    	 
		         String line = sc2.nextLine();
		         
		         if(line.indexOf(w)!=-1) {
		           
		        	 found=true;
		        	 flag = true;
		             count = count+1;
		         }
		      }
		      
		      if(flag) {
		    	  
			         System.out.println("File " + file +" contains '" + w +"'");
			         System.out.println("Frequency of '" + w + "':" + count);
			      } 
			      
			  else {
			         System.out.println("File " + file +" does not contain '" + w +"'");
			      }
				
		      
			}
		}
		
		else if(opt==5) {
			System.out.println("Program Exit");
			System.exit(0);;
		}
		
		else {
			System.out.println("Invalid Input");
		}
	}


}
