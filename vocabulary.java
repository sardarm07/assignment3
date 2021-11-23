package i192015_A3;

import java.util.Scanner;

public class vocabulary extends Thread {
	
	String file;
	
	vocabulary(String f)
	{
		this.file=f;
	}

	public void run()
	{
		
		
		try {
			
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine())
			{
				String data=scan.nextLine();
				String str[]=data.split(" ");
				for(String w:str) {
					System.out.println(w);
					DriverClass.b.insert(w);  
				}
			}
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
