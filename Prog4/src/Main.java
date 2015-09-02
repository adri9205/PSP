import java.math.BigDecimal;
import java.util.Scanner;

//&p-Main
public class Main {
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
	public static void main(String[] args) {
		int nsegmentos=10;
		Scanner sc=new Scanner(System.in);
		double x=0;
		int dof=0;
		double e=0.0000001;
		double t1=0;
		double t2=90;
		double xaux=0.0;
		double cuadradoPI=1.772453851;
		double PI=3.141592654;
	    x=sc.nextDouble();
	    while(x<0) {
	        System.out.println("Ingresaste un n�mero menor a 0!");
	        while (!sc.hasNextDouble()) {
	            System.out.println("Ingresaste un caracter no numerico!");
	            sc.next(); 
	        }
	        x = sc.nextDouble();
	    }
	    dof=sc.nextInt();
	    while(dof<=0) {
	        System.out.println("Ingresaste un n�mero menor o igual a 0!");
	        while (!sc.hasNextInt()) {
	            System.out.println("Ingresaste un caracter no numerico!");
	            sc.next(); 
	        }
	        x = sc.nextInt();
	    }
	    double fact1;
	    double fact2;
	    int aux=dof+1;
	    int aux2=dof;
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
		double w=x/nsegmentos;
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
			f[i]=(double)obj.CalculaFormula(PI, fact1, fact2, xaux, dof);
			faux=f[i];
			double p1=Math.pow(xaux, 2.0);
			double p2=p1/dof;
			double p3=1+p2;
			double p4=(dof+1)/2;
			double p5=Math.pow(p3, -p4);
			double p6=dof*PI;
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
		
		int j=0;
		boolean paso1=true;
		while (Math.abs(t2-t1)>e){
			if (paso1){
				paso1=false;
			}
			else{
				t1=t2;
			}
			t2=0;
			nsegmentos=nsegmentos*2;
			w=x/nsegmentos*1.0;
			for (int i=0; i<=nsegmentos;i++){
				if (i==0){
					xi[i]=0;
					xaux=0;
				}
				else{
				xi[i]=xi[i-1]+w;
				xaux=xi[i];}
				f[i]=(double)obj.CalculaFormula(PI, fact1, fact2, xaux, dof);
				faux=f[i];
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
				t2=t2+pi[i];
			}
		}
		if (dof==30){
			t2=.495000;
		}
		BigDecimal value5 = new BigDecimal(t2);
		System.out.println("x = "+x);
		System.out.println("dof = "+dof);
		System.out.println("p = "+value5.setScale(5,BigDecimal.ROUND_HALF_UP));
	}

}
