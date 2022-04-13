package com.stepik.basejava.module2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCalcFileManyLines {

	public static void main(String[] args) {
		String[] s = {"", "", ""};
		
	
		ArrayList<String> MathS = new ArrayList<>();
		
		File file = new File("d:\\input.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            MathS.add(sc.nextLine());
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
		for(int p = 0; p < MathS.size(); p++) {
			
			String inp = MathS.get(p);
		 
			String sbuf = MathS.get(p);
			
		    s = sbuf.split(" ");
		    
		    String ansSt = "";
		    
		    
		    if (inp.equals("")) {}
		    else if (s.length != 3) {
		    	
		    	ansSt = "Некорректный ввод";
		    }
		    else {
		    	
		    
            sbuf = s[2];
            s[2] = s[1];
            s[1] = sbuf;

		
		
		
		double[] dm = new double[2];
		
		boolean work = true;
		
		for (int i = 0; i < 2; i++) {
			try {	
			dm[i] = Double.parseDouble(s[i]); 
			}	
		
		catch (NumberFormatException n1) {
			ansSt = "Error! Not number";
			work = false;
			break;
		}
		}
		

		if (!work) {}
		else if (s[2].equals("+")) {
			ansSt = dm[0] + dm[1] + "";
		}
		else if (s[2].equals("-")) {
			ansSt = dm[0] - dm[1] + "";
		}
		else if (s[2].equals("/")) {

			
			double ans = dm[0] / dm[1];
			
			if (Double.isNaN(ans) || Double.isFinite(ans) 
					|| Double.isInfinite(ans)) {
				ansSt = "Error! Division by zero";
				
			}
			else {			
				ansSt = ans + "";
			}
		}
		else if (s[2].equals("*")) {
			ansSt = dm[0] * dm[1] + "";
		}
		else {
			ansSt = "Operation Error!";
		}
		    }
		    
		boolean wr = true;
		
		if (p == 0) wr = false; 
		
		 //https://metanit.com/java/tutorial/6.8.php
        try(FileWriter writer = new FileWriter("d:\\output.txt", wr))
        {
           // запись всей строки
            //String text = "Hello Gold!";
        	if(!ansSt.equals("")) {
            writer.write(inp + " = " + ansSt); }
            // запись по символам
            writer.append('\n');
           // writer.append('E');
             
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
        
		}
    } 
		
		
}


