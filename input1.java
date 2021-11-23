package i192015_A3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.lang.Thread;
import java.lang.Runnable;


public class input1 extends Thread {

	String file;
	
	input1(String f){
		
		this.file=f;
	}
	
	 public void run()
	 {
		 
		 File file = new File(this.file);
		  
		  try {
				Scanner scan=new Scanner(file);
				while(scan.hasNextLine())
				{
				    DriverClass.vector.add(scan.next());  
				}
			
		  }
		  catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  Scanner scan1;
		  
		try {
			
			scan1 = new Scanner(file);
			
			String word; 
			
			int i=0;
			while(scan1.hasNextLine())
			{
			    word=scan1.next();
			   
			    boolean found = DriverClass.b.search(word);
			  
			    if(found==true)
			    	
			    {
			    	boolean find=false;
			    	
			    	int n=DriverClass.w.size();
			    	
			    	for(int j=0;j<n;j++)
			    	{
			    		if(word.compareTo(DriverClass.w.get(j).getWord())==0) {
			    			find=true;
			    			DriverClass.w.get(j).setFrequency(DriverClass.w.get(j).getFrequency()+1);
			    		}
			    			
			    		
			    	}
			    	
			    	if(!find) {
			    		DriverClass.w.add(i,new word(word,1));
			    		i++;
			    	}
		    			
			    }
			    
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	 }
	 
	
}
