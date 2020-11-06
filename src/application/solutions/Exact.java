package application.solutions;

public class Exact extends Solutions{
	public Exact(double x0, double y0, double X, int N) {
		super(x0, y0, X, N);
		// TODO Auto-generated constructor stub
	}
	public double[] useExact(double a, double b, double c, int d) {
		double[] yn= new double[d+1];
		double C = (a*b-2)*(Math.cbrt(a)*a)/(b*Math.pow(a,2)-a);
		yn[0] = b; xn[0]=a;
		double h = (c-a)/d;
		for(int i = 1; i <= d; i++) {
				xn[i]=xn[i-1]+h;
				yn[i]=ef(xn[i],C);
		}
		return yn;
	}
	
	public double ef(double a,  double c) {
		double e = (c-2*Math.cbrt(a))/(a*(c-Math.cbrt(a)));
		return e;
	}
}
