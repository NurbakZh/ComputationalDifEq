package application.solutions;

public class RK extends Solutions{

	public RK(double x0, double y0, double X, int N) {
		super(x0, y0, X, N);
		// TODO Auto-generated constructor stub
	}

	public double[] useRK(double a, double b, double c, int d) {
		double[] yn= new double[d+1];
		yn[0]=b; xn[0]=a;
		double h = (c-a)/d;
		for(int i = 1; i <= d; i++) {
			double k1 = f(xn[i-1],b);
			double k2 = f((xn[i-1]+h/2),b+((h*k1)/2));
			double k3 = f((xn[i-1]+h/2),b+((h*k2)/2));
			double k4 = f(xn[i-1]+h,b+h*k3);
			double t = (k1+2*k2+2*k3+k4)/6;
			yn[i]=b+h*t;
			b=yn[i];
			xn[i]=xn[i-1]+h;
		}
		return yn;
	}
}
