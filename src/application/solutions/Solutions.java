package application.solutions;

public class Solutions {
	double a,b,c,d;
	static double[] xn = new double[10000];
	public Solutions(double x0, double y0, double X, int N) {
		a=x0;
		b=y0;
		c=X;
		d=N;
	}

	public double[] getX() {
		return xn;
	}
	public double f(double a, double b) {
		double c = -(Math.pow(b,2))/3-2/(3*Math.pow(a,2));
		return c;
	}
	public static void main(String[] args) {
        
    }
	
}

