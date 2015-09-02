package com.programa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaVacias vacias;
		CuentaCar car;
		int totalem=0, totallin=0, totalcar=0;
		    
		int linenumber = 1, nomarch=0;
		/*try{
			
			Scanner sc= new Scanner(System.in);
			String archivo;
			int totalem=0, totallin=0, totalcar=0;
			int totalarch=0;
			boolean fin=false;
			while(sc!=null){
			archivo=sc.next();
			int v=1;
			String line;
			int l = 1;
			int linea=1;
			
    		File file =new File(archivo);
    		File file2= new File(archivo);
    		totalarch+=1;
 
			
			}
			}*/
		try{
			Scanner sc= new Scanner(System.in);
			while(sc!=null){
			String archivo=sc.next();
    		File file =new File(archivo);
 
    		if(file.exists()){
 
    		    FileReader fr = new FileReader(file);
    		    FileReader fr2 = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
    		    LineNumberReader lnr2 = new LineNumberReader(fr2);
    		    FileReader fr3 = new FileReader(file);
    		    LineNumberReader lnr3 = new LineNumberReader(fr3);

    		    String l, line;
    		    int e, c, e2=1;
    		    e=0;
    		    c=0;
    		    if (lnr.readLine()!=null){
 
    	            while (lnr.readLine() != null){
    	            	linenumber++;
    	        
    	            }
    	            while ((line=lnr2.readLine()) != null){
    	            	
    	        	 if (line.trim().isEmpty()) {
    	        		 e2++;
    	     		    
    	     		  }
    	        	 else{
    	        		 c++;
    	        	 }
    	        	 
    	            }
    	            linenumber=e2+c;
    	            
    	            System.out.println("Nombre de archivo : " + archivo);
    	            System.out.println("Total de numero de lineas : " + linenumber);
       	            System.out.println("Total de numero de lineas vacias : " + e2);
       	            System.out.println("Total de numero de lineas con informacion : " + c);
       	            totalem+=e2;
       	            totalcar+=c;
       	            totallin+=linenumber;
       	            e2=1;
       	            c=1;
       	            linenumber=1;
       	            nomarch++;
    	            lnr.close();
 
 
    		}else{
    			 System.out.println("Arhivo NULO!");
    		}}
    		else{
    			System.out.println("Arhivo no existe! Verifica la extension o el nombre");
    		}
	            System.out.println("Total de archivos leidos : " + nomarch);
	            System.out.println("Total de numero de lineas leidas de los archivos : " + totallin);
   	            System.out.println("Total de numero de lineas vacias : " + totalem);
   	            System.out.println("Total de numero de lineas con informacion : " + totalcar);

			}
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
 
			}
	}
			


