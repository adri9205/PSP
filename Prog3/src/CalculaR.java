
//&p-CalculaR
public class CalculaR {
	double sumxy;
	double avex;
	double avey;
	double xalcua;
	double yalcua;
	double avexcua;
	double aveycua;
	int n;
	double sumxycua;
	double sumx;
	double sumy;
	double [] x1;
	double [] y1;
	double result;
	double nxy;
	double nxcu;
	double nycu;
	double multxy;
	double result1;
	double result2;
	public CalculaR(){
		 sumxy=0;
		 avex=0;
		 avey=0;
		 xalcua=0;
		 yalcua=0;
		 avexcua=0;
		 aveycua=0;
		 n=Main.i;
		 sumxycua=0;
		 sumx=0;
		 nxy=0;
		 sumy=0;
		 result=0;
		 nxcu=0;
		 nycu=0;
		 multxy=0;
		 result1=0;
		 x1=Main.returnArrayX();
		 y1=Main.returnArrayY();}
	//&i
	public double Resultado(){
		x1=Main.returnArrayX();
	    y1=Main.returnArrayY();
		for (int j=1; j<=n; j++){
			sumx+=x1[j];
			sumy+=y1[j];
			sumxy+=(y1[j]*x1[j]);
			xalcua+=Math.pow(x1[j],2);
			yalcua+=Math.pow(y1[j],2);
		}
		nxy=n*sumxy;
		nxcu=n*xalcua;
		nycu=n*yalcua;
		avex=Math.pow(sumx, 2);
		avey=Math.pow(sumy, 2);
		multxy=sumx*sumy;
		result1=Math.sqrt((nxcu-avex)*(nycu-avey));
		result=(nxy-multxy)/(result1);
		return result; }
	//&i
	public double Resultadorcua(){
		result2=Math.pow(result, 2);
		return result2; }}
