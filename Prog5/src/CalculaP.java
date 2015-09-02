//&p-CalculaP
public class CalculaP {
int mult=0;
double fx=0;
double w=0;
double resultado=0;
double w3=0;
double fr=0;
double fx2=0;
//&b=23
//&i
public void CalculaP(){
	mult=0;
	fx=0;
	w=0;
	resultado=0;
	w3=0;
	fx2=0;
	fr=0;
}
//&i
public double CalculaFormula(double w1, int m, double f){
	this.mult=m;
	this.w=w1;
	this.fx=f;
	w3=w/3.0;
	resultado=w3*mult*fx;
	return resultado;
}
}
