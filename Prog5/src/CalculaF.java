//&p-CalculaF
//&b=37
public class CalculaF {
double fac1=0;
double fact2=0;
double xi=0;
double df=0;
double op1=0;
double op2=0;
double op3=0;
double op4=0;
double op5=0;
double resultado=0;
double PI=0;
//&i
public void CalculaF(){
	fac1=0;
	fact2=0;
	xi=0;
	df=0;
	op1=0;
	op2=0;
	op3=0;
	op4=0;
	op5=0;
	resultado=0;
	PI=0;
}
//&i
public double CalculaFormula(double p, double fact1, double fac2, double x, double dof){
	this.PI=p;
	this.fac1=fact1;
	this.fact2=fac2;
	this.xi=x;
	this.df=dof;
	op1=Math.sqrt(df*PI);
	op2=1+((Math.pow(xi,2))/df);
	op3=(-(df+1)/2.0);
	op4=Math.pow(op2, op3);
	op5=op1*fact2;
	resultado=(fac1/op5)*op4;
	return resultado;
}
}
