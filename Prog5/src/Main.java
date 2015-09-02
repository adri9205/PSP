import java.math.BigDecimal;
import java.util.Scanner;

//&p-Main
//&b=104
public class Main {

	static double p=0;
	static int dof=0;
	static double e=0.000001;
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
		
		return t1;
	}
	//&i
	static double FindX(double p1, int dofd)
    {
		double x=1.0;
		double p2=0;
		double prev=0;
		double actual=0.0;
		double d=0.5;
		p2=simpson(x,dof);
		
		if (p2<p1){
			x=x+d;
		}
		else 
		{
			x=x-d;
		}
		prev=p2-p1;
	
		while (Math.abs(p2-p1)>e){
			p2=simpson(x,dof);
			
			actual=p2-p1;
			if (prev>0&&actual<0){
				d=d/2;
			}
			else if (prev<0&&actual>0){
				d=d/2;
			}
			else{
				d=d;
			}
			if (p2>p1){
			    x=x-d;	
			}
			else {
				x=x+d;
			}
			if (x<=0){
				while (x<=0){
					x=x+d;
				}
			}
			prev=actual;
			
		}
		
		    return x;
		  }
	
	//&i
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    p=sc.nextDouble(); //&m
	    while(p<0) { 
	        System.out.println("Ingresaste un n�mero menor a 0, debe ser mayor, intenta de nuevo");
	        while (!sc.hasNextDouble()) {
	            System.out.println("Ingresaste un caracter no numerico!");
	            sc.next(); 
	        }
	        p = sc.nextDouble(); //&m
	    }
	    dof=sc.nextInt();
	    while(dof<=0) {
	        System.out.println("Ingresaste un n�mero menor a 0, debe ser mayor, intenta de nuevo");
	        while (!sc.hasNextInt()) {
	            System.out.println("Ingresaste un caracter no numerico!");
	            sc.next(); 
	        }
	        dof = sc.nextInt();
	    }
	    double t2=FindX(p,dof); //&m
	    double t3=simpson(.35,10);
		BigDecimal value5 = new BigDecimal(t3);
		System.out.println("p = "+p);
		System.out.println("dof = "+dof);
		System.out.println("x = "+value5.setScale(5,BigDecimal.ROUND_HALF_UP));
		
	}

}
