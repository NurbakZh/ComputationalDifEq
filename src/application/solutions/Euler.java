package application.solutions;

public class Euler extends Solutions{
	public Euler(double x0, double y0, double X, int N) {
		super(x0, y0, X, N);
		// TODO Auto-generated constructor stub
	}

	public double[] useEuler(double a, double b, double c, int d) {
		double[] yn= new double[d+1];
		yn[0] = b; xn[0]=a;
		double h = (c-a)/d;
		for(int i = 1; i <= d; i++) {
			yn[i]=b+h*f(xn[i-1],b);
			b=yn[i];
			xn[i]=xn[i-1]+h;
		}
		return yn;
	}
	
	
}
