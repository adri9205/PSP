//&p-Main
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.util.Scanner;
public class Main {
	public static double[] arrX= new double [100];
	public static double[] arrY= new double [100];
	public static int i;
	public static double xk;
	//&i
	public static void main(String[] args) {
		double xiyi=0;
		double nxiyi=0;
		double averagex=0;
		double averagey=0;
		double xalcua=0;
		double averagexalcua=0;
		double beta=0;
		double beta1=0;
		double sumX=0;
		double sumY=0;
		double sumXalcua=0;
		double sumYalcua=0;
		double sumXelevado=0;
		double sumYelevado=0;
		double nxy=0;
		double nxalcua=0;
		double sumXdespuesalcua=0;
		double sumYdespuesalcua=0;
		double nxialcua=0;
		double nyialcua=0;
		double r=0;
		double ralcua=0;
		double aux=0;
		double yk=0;
		try{
			Scanner sc= new Scanner(System.in);
			String archivo=sc.next();
    		File file =new File(archivo);
    		if(file.exists()){
    			if (file!=null){
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
    		    int linenumber = 1;
    		    String l;
    		    String line;
    		    i=0;
    		    xk=0;
    	           if ((l=lnr.readLine()) != null){ //&m
    	        	  xk=Double.parseDouble(l);
    	        	 
    	        	  }
 	        	  
    	            while ((line=lnr.readLine()) != null){
    	            	if (!line.trim().isEmpty()) {
    	            	String str = line;
    	            	i++;
    	            	String[] parts = str.split(",");
    	            	String xnum = parts[0]; 
    	        		String ynum = parts[1]; 
    	        		if (!xnum.trim().isEmpty()){
    	        		arrX[i]=Double.parseDouble(xnum);
    	        		}
    	        		else{
    	        			arrX[i]=0;
    	        		}
    	        		if (!ynum.trim().isEmpty()){
    	        		arrY[i]=Double.parseDouble(ynum);}
    	            	 }
    	            	else{
    	            		arrY[i]=0;
    	            	}
    	            	}
    	            lnr.close();}
    			else{
    				System.out.println("El archivo es nulo!");}
    			
    		}else{
    			 System.out.println("El archivo no existe!");}
    		for (int j=1; j<=i; j++){
    		sumX+=arrX[j];
    		sumY+=arrY[j];
    		xiyi+=(arrX[j]*arrY[j]);
    		sumXalcua+=Math.pow(arrX[j], 2);
    		sumYalcua+=Math.pow(arrY[j], 2);}
    		averagex=sumX/i;
    		averagey=sumY/i;
    		nxy=averagex*averagey*i;
    		nxiyi=xiyi*i;
    		averagexalcua=Math.pow(averagex, 2);
    		nxalcua=i*averagexalcua;
    		sumXdespuesalcua=Math.pow(sumXalcua,2);
    		sumYdespuesalcua=Math.pow(sumYalcua, 2);
    		nxialcua=sumXalcua*i;
    		nyialcua=sumYalcua*i;
    		double sumXalcu=0;
    		double sumYalcu=0;
    		sumXalcu=Math.pow(sumX, 2);
    		sumYalcu=Math.pow(sumY, 2);
    		double rest1=0;
    		double rest2=0;
    		rest1=nxialcua-sumXalcu;
    		rest2=nyialcua-sumYalcu;
    		double mult=0;
    		mult=rest1*rest2;
    		aux=Math.sqrt(mult);
    		beta1=(xiyi-nxy)/(sumXalcua-nxalcua);
    		beta=averagey-(beta1*averagex);
    		r=(nxiyi-(sumX*sumY))/(aux);
    		ralcua=r*r;
    		yk=beta+(beta1*xk);
    		CalculaR r1= new CalculaR();
    		Beta1 b1=new Beta1();
    		Beta0 b0=new Beta0();
    		System.out.println("N= "+i);
    		System.out.println("Xk= "+xk);
    		BigDecimal value5 = new BigDecimal(r);
    		BigDecimal value6 = new BigDecimal(ralcua);
    		BigDecimal value7 = new BigDecimal(beta);
    		BigDecimal value8 = new BigDecimal(beta1);
    		BigDecimal value9 = new BigDecimal(yk);
    		System.out.println("r= "+value5.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("r2= "+value6.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("b0= "+value7.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("b1= "+value8.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("yk= "+value9.setScale(5, BigDecimal.ROUND_HALF_UP));
    	}catch(IOException e){
    		e.printStackTrace(); //&base=25
    		}
	}
	//&i
	public static double[] returnArrayX()
    {
         return(arrX);   
    }
	//&i
	public static double[] returnArrayY()
    {
         return(arrY);   
    }


}
