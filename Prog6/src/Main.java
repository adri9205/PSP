//&p-Main
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.util.Scanner;
public class Main {
	//&d=10
	//&b=189
	public static double[] arrX= new double [100];
	public static double[] arrY= new double [100];
	public static int i;
	public static double xk;
	static double e=0.0000001;
	static double t2=90;
	static double xaux=0.0;
	static double cuadradoPI=1.772453851;
	static double PI=3.141592654;
	static int nsegmentos=40;
	//&i
		public static int factorial(int n){
				if (n==0){
					return 1;
				}
				else{
					return n*factorial(n-1);
				}
		}
		//&i
		public static double factorialdecimal(int n){
			double f=1;
			int d=n;
			double cuadradoDePI=1.772453851;
			for (int i=d-2; i>=1; i=i-2){
				f=f*(i/2.0);
		}
			f=f*cuadradoDePI;
			return f;
		}
		//&i
		public static double simpson(double xs, int dofs){
			double p=0;
			double t1=0;
			double fact1=0;
		    double fact2=0;
		    int aux=dofs+1;
		    int aux2=dofs;
		    CalculaP obj2=new CalculaP();
		    if (aux%2==0){
		    	int aux3=aux/2;
		    	fact1=factorial(aux3-1);
		    
		    }
		    else{
		    	fact1=factorialdecimal(aux);
		    }
		    if (aux2%2==0){
		    	int aux4=aux2/2;
		    	fact2=factorial(aux4-1);
		    }
		    else{
		    	fact2=factorialdecimal(aux2);
		    }
			int multaux=0;
			CalculaF obj= new CalculaF();
			double [] f2=new double[1000];
			double f2aux=0;
			double [] xi= new double [1000];
			int [] mult= new int [1000];
			double [] f= new double [1000];
			double [] pi= new double [1000];
			double w=xs/nsegmentos;
			double faux=0;
			for (int i=0; i<=nsegmentos;i++){
				if (i==0){
					xi[i]=0;
					xaux=0;
				}
				else{
				xi[i]=xi[i-1]+w;
				xaux=xi[i];
				}
				f[i]=(double)obj.CalculaFormula(PI, fact1, fact2, xaux, dofs);
				faux=f[i];
				double p1=Math.pow(xaux, 2.0);
				double p2=p1/dofs;
				double p3=1+p2;
				double p4=(dofs+1)/2;
				double p5=Math.pow(p3, -p4);
				double p6=dofs*PI;
				double p7=Math.sqrt(p6);
				double p8=p7*fact2;
				double p9=fact1/p8;
				if (i==0){
					mult[i]=1;
					multaux=1;
				}
				else if (i==nsegmentos){
					mult[i]=1;
					multaux=1;
				}
				else if (i%2==0){
					mult[i]=2;
					multaux=2;
				}
				else{
					mult[i]=4;
					multaux=4;
				}
				pi[i]=(double)obj2.CalculaFormula(w, multaux, faux);
				t1=t1+pi[i];
			}
			
			return t1;
		}

	//&i
	public static double desviacionestandar(int n, double desvalcua, int dof){
		double div=1/(dof*1.0);
		return  Math.sqrt(div*desvalcua);
	}
	//&i
	public static double rango(double averagex, int n, double x, double xi, double t, double desviacion){
		double rand=0;
		double division=x/xi;
		double ki=1+division;
		double ki2=1.0/n;
		double ki3=ki+ki2;
		rand=Math.sqrt(ki3)*desviacion*t;
		return rand;
	}
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
    	           if ((l=lnr.readLine()) != null){ 
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
    				System.out.println("Este archivo no contiene datos!");}//&m
    			
    		}else{
    			 System.out.println("Este archivo no contiene datos!");}//&m
    		for (int j=1; j<=i; j++){
    		sumX+=arrX[j];
    		sumY+=arrY[j];
    		xiyi+=(arrX[j]*arrY[j]);
    		sumXalcua+=Math.pow(arrX[j], 2);
    		sumYalcua+=Math.pow(arrY[j], 2);
    		}
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
    		double desv=0;
    		double desvalcua=0;
    		double desviacion=0;
    		double t=0;
    		double xiNew=0;
    		int dof=i-2;
    		double valorX=0;
    		double x=0;
    		double absolutoR=Math.abs(r);
    		double raiznminus2=Math.sqrt(dof);
    		double raiz1menosrcua=Math.sqrt(1-(Math.pow(r,2)));
    		double p1=0;
    		double cola=0;
    		double upi=0;
    		double lpi=0;
    		for (int k=1;k<=i; k++){
    			double resta=arrX[k]-averagex;
    			xiNew+=Math.pow(resta, 2);
    			double mu=beta1*arrX[k];
    			desv+=arrY[k]-beta-mu;
    			desvalcua+=Math.pow(desv, 2);
    			
    		}
    		
    		t=simpson(.35,dof);
    		x=Math.pow(xk-averagex, 2);
    		desviacion=desviacionestandar(i,desvalcua,dof);
    		valorX=(absolutoR*raiznminus2)/raiz1menosrcua;
    		p1=simpson(valorX,dof);
    		double p2=simpson(valorX,i);
    		cola=1-(2*p1);
    		double kl=1/(i*1.0);
    		double kl2=kl*1.0;
    		
    		double sumayib0b1xi=0;
    		double sumayib0b1xi2=0;
    		double v=0;
    		for (int o=1; o<=i; o++){
    			sumayib0b1xi+=arrY[o]-beta-(beta1*arrX[o]);
    			sumayib0b1xi2+=Math.pow(arrY[o]-beta-(beta1*arrX[o]), 2);
    		}
    		v=Math.pow(sumayib0b1xi, 2);
    		
    		double division=1.0/(dof*1.0);
    		double d2=0;
    		d2=Math.sqrt(division*v);
    		double d3=0;
    		d3=Math.sqrt(division*sumayib0b1xi2);
    		
    		double division2=1.0/(i*1.0);
    		double u=xk-averagex;
    		double u2=Math.pow(u, 2);
    		double s1=0;
    		double s2=0;
    		for (int w=1; w<=i; w++){
    			s1+=arrX[w]-averagex;
    			s2+=Math.pow(arrX[w]-averagex,2);
    		}
    		double s3=Math.pow(s1,2);
    		double e01=0;
    		e01=u/s3;
    		double s4=Math.pow(s2,2);
    		double e02=u/s4;
    		double e04=Math.sqrt(1.0+e02+division2);//d2,d3
    		double e08=p1*d3*e04;
    		upi=yk+e08;
    		lpi=yk-e08;
    	
    		System.out.println("N= "+i);
    		System.out.println("Xk= "+xk);
    		BigDecimal value5 = new BigDecimal(r);
    		BigDecimal value6 = new BigDecimal(ralcua);
    		BigDecimal value7 = new BigDecimal(beta);
    		BigDecimal value8 = new BigDecimal(beta1);
    		BigDecimal value9 = new BigDecimal(yk);
    		BigDecimal value10 = new BigDecimal(cola);
    		BigDecimal value11 = new BigDecimal(rango(averagex,i,x,xiNew,t,desviacion));
    		BigDecimal value12 = new BigDecimal(upi);
    		BigDecimal value13 = new BigDecimal(lpi);
    		System.out.println("r= "+value5.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("r2= "+value6.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("b0= "+value7.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("b1= "+value8.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("yk= "+value9.setScale(5, BigDecimal.ROUND_HALF_UP));
    		System.out.println("sig= "+cola);
    		System.out.println("ran= "+e08);
    		//System.out.println("ran= "+value11.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("LS= "+value12.setScale(5,BigDecimal.ROUND_HALF_UP));
    		System.out.println("LI= "+value13.setScale(5, BigDecimal.ROUND_HALF_UP));
    	}catch(IOException e){
    		e.printStackTrace(); 
    		}
	}
}
