import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
//d=10;
	//b=17;
	public static void main(String[] args) {
		int blanco=0;
		int [] blanco1=new int[2000];
		int blancoaux=0;
		int indice=0;
		int dobleslash=0;
		int [] dobleslash1= new int [2000];
		int dobleslashaux=0;
		int llaveabierta=0;
		int [] llaveabierta1=new int [2000];
		int llaveabiertaaux=0;
		int llavecerradaaux=0;
		int llavecerrada=0;
		int [] llavecerrada1=new int [2000];
		int del1=0;
		int n=0;
		int [] delaux= new int [2000];
		int base1=0;
		int [] baseaux=new int [2000];
		int TLDC=0;
		int items=0;
		int itemsaux=0;
		int [] itemaux=new int [2000];
		int del=0;
		int auxbase=0;
		int auxdel=0;
		int [] baseauxi=new int [2000];
		int [] delauxi=new int [2000];
		int diferencia2=0;
		int [] diferencia2aux=new int [2000];
		int add=0;
		int mod=0;
		int modaux=0;
		int base=0;
		int totalparte=0;
		int diferencia=0;
		int veces=0;
		int vecesaux=0;
		int diferenciaux=0;
		int aux1=0, aux2=0, aux3=0, aux4=0;
		boolean auxdiferencia=false;
		String [] nombre=new String [2000];
		int [] item=new int [2000];
		int [] borradas=new int [2000];
		int [] agregadas=new int [2000];
		int  [] modificadas=new int [2000];
		int [] based=new int [2000];
		int [] totales=new int [2000];
		int[] pos=new int[2000];
		int[] partestotales=new int [2000];
		int tf=0;
		
		try{
			System.out.println("Cuantos archivos vas a ingresar?");
			Scanner sc= new Scanner(System.in);
			n=sc.nextInt();
			for (int j=0; j<n; j++){
			String archivo=sc.next();
    		File file =new File(archivo);
    		
    		if(file.exists()){
    		    FileReader fr = new FileReader(file);
    		    FileReader fr2 = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
    		    LineNumberReader lnr2 = new LineNumberReader(fr2);
    		    String line;
 
    	            while (lnr.readLine() != null){
    	            	
    	            	tf++;
    	                
    	            }
    	           auxbase=0;
 	        	   auxdel=0;
 	        	   llaveabiertaaux=0;
 	        	   llavecerradaaux=0;
 	        	   itemsaux=0;
 	        	   modaux=0;
 	        	   TLDC=0;
 	        	   vecesaux=0;
 	        	   diferenciaux=0;
 	        	   blancoaux=0;
 	        	   dobleslashaux=0;
 	        	   blancoaux=0;
    	            while ((line=lnr2.readLine()) != null){
    	            	aux1++;
    	            	aux2++;
    	        	 if (line.trim().isEmpty()) {
    	        		 blanco++;
    	        		 blancoaux++;
    	     		    
    	     		  }
    	        	 else if (line.trim().startsWith("//&p-")){
    	        	  
    	        	   blanco1[indice]=blancoaux;
    	        	   dobleslash1[indice]=dobleslashaux;
    	        	   diferencia2aux[indice]=vecesaux+diferenciaux;
    	        	   llaveabierta1[indice]=llaveabiertaaux;
    	        	   llavecerrada1[indice]=llavecerradaaux;
    	        	   partestotales[indice]=TLDC;
    	        	   auxbase=0;
    	        	   auxdel=0;
    	        	   llaveabiertaaux=0;
    	        	   llavecerradaaux=0;
    	        	   itemsaux=0;
    	        	   modaux=0;
    	        	   TLDC=0;
    	        	   vecesaux=0;
    	        	   diferenciaux=0;
    	        	   blancoaux=0;
    	        	   dobleslashaux=0;
    	        	   indice++;
    	        	   pos[indice]=aux1;
    	        	   String nom=line;
    	        	   String[] splitted=nom.split("[\\s-]");
    	        	   nombre[indice]=splitted[1];
    	        	   
    	        	   
    	        	 }
    	        	 else if (line.contains("; //&m")){
    	        		 mod++;
    	        		 modaux++;
    	        		 TLDC++;
    	        		 modificadas[indice]+=modaux;
    	        	 }
    	        	 else if (line.trim().startsWith("//&i")){
    	        		 items++;
    	        		 itemsaux++;
    	        		 item[indice]=itemsaux;
    	        	 }
    	        	 else if (line.trim().startsWith("//&d=")){
    	        		 del=convierteNumero(line);
    	        		 del1++;
    	        		 auxdel++;
    	        		 borradas[indice]+=del;
    	        		 delauxi[indice]=auxdel;
    	        	 }
    	        	 else if (line.trim().startsWith("//&b=")){
    	        		 base=convierteNumero(line);
    	        		 base1++;
    	        		 auxbase++;
    	        		 based[indice]+=base;
    	        		 
    	        		 baseauxi[indice]=auxbase;
      	        	  
      	        	   
    	        		 
    	        	 }
    	        	 else if (line.trim().startsWith("//")){
    	        		 dobleslash++;
    	        		 dobleslashaux++;
    	        	 }

    	        	 else if (line.trim().startsWith("/*")){
    	        		 auxdiferencia=true;
    	        		 aux3=aux1;
    	        		 veces++;
    	        		 vecesaux++;
    	        	 }
    	        	 
    	        	 
    	        	 else if (line.trim().startsWith("*/")||line.contains("*/")){
    	        		 auxdiferencia=false;
    	        		 aux4=aux2;
    	        		 diferencia=aux4-aux3;
    	        		 diferenciaux=aux4-aux3;
    	        		 
    	        	 }
    	        	 
    	        	 else if (line.trim().startsWith("}")){
    	        		 int chars=line.trim().length();
    	        		 if (chars==1){
    	        		 llavecerrada++;
    	        		 llavecerradaaux++;
    	        		 }
    	        		 else{
    	        			TLDC++; 
    	        		 }

    	        	 }
    	        	 
    	        	 else if (line.trim().startsWith("{")){
    	        		 
    	        		 int chars=line.trim().length();
    	        		 if (chars==1){
    	        		 llaveabierta++;
    	        		 llaveabiertaaux++;
    	        		 }
    	        		 else{
    	        			TLDC++; 
    	        		 }
    	        		
    	        	 }
    	        	 else{
    	        		 TLDC++;
    	        	 }
    	        	 
    	        	 
    	        	 
    	            }
    	            lnr.close();
    		
    	    
    	          
    		}else{
    			 System.out.println("Archivo no existe!");
    		}
    		
            partestotales[indice]=TLDC;    	            
            pos[indice+1]=tf;
            for (int i=1; i<=indice; i++){
            	agregadas[i]=partestotales[i]-based[i]+borradas[i];            
            }
            System.out.println("PARTES BASE:");
            for (int i=1; i<=indice; i++){
            	if (borradas[i]>0){
            	System.out.println(nombre[i]+": T="+partestotales[i]+" I="+item[i]+" B="+based[i]+" D="+borradas[i]+" M="+modificadas[i]+" A="+agregadas[i]);
            	}
            	else if (modificadas[i]>0){
            		System.out.println(nombre[i]+": T="+partestotales[i]+" I="+item[i]+" B="+based[i]+" D="+borradas[i]+" M="+modificadas[i]+" A="+agregadas[i]);
            	}
            	/*else if (based[i]>0){
            		System.out.println(nombre[i]+": T="+partestotales[i]+" I="+item[i]+" B="+based[i]+" D="+borradas[i]+" M="+modificadas[i]+" A="+agregadas[i]);
            		
            	}*/
            }
            System.out.println("------------------------------------------------------------------");
            System.out.println("PARTES NUEVAS:");
            for (int i=1; i<=indice; i++){
            	if (based[i]==0){
            		System.out.println(nombre[i]+": T="+partestotales[i]+" I="+item[i]);
            	}
            }
            System.out.println("------------------------------------------------------------------");
            System.out.println("PARTES REUSADAS:");
            for (int i=1; i<=indice; i++){
            	if (based[i]>0&&(borradas[i]==0&&modificadas[i]==0&&agregadas[i]==0)){
            		System.out.println(nombre[i]+": T="+partestotales[i]+" I="+item[i]+" B="+based[i]);
            	}
            	
            }
            System.out.println("------------------------------------------------------------------");
            diferencia2=veces+diferencia;
            int TDOC=tf-blanco-llaveabierta-llavecerrada-dobleslash-diferencia2-base1-del1-indice-items;
          
            
            System.out.println("Total de LDC: "+TDOC);
            
			}
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		

		

	}
	
	public static int convierteNumero(String numero){
		//metodo para convertir de un string como //d=33 a un numero
		String str = numero;
		str=str.replaceAll("[\\D]+"," ");
		String[] numbers=str.split(" ");
		int sum = 0;
		for(int i=0;i<numbers.length;i++){
		    try{
		        sum+=Integer.parseInt(numbers[i]);
		    }
		    catch( Exception e ) {
		    }
		}
		return sum;
	}

}
