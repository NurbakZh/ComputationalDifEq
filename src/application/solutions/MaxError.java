package application.solutions;

public class MaxError {
	//Max Error
	public static double[] getMEr(double x0, double y0, double X, int N, int n0, int a) {
		double[] ans = new double[N-n0+1];
		if(a==1) {
			int ch=n0;
			for(int i = 0; i<(N-n0+1); i++) {
				Euler e = new Euler(x0,y0,X,ch);
				double[] ef = e.useEuler(x0,y0,X,ch);
				Exact y = new Exact(x0,y0,X,ch);
				double[] yx = y.useExact(x0,y0,X,ch);
				double max = -1;
				for(int j =0;j<ch;j++) {
					if(Math.abs(yx[j]-ef[j])>max) max=Math.abs(yx[j]-ef[j]);
				}
				ans[i]=max;
				ch++;
			}
		}
		if(a==2) {
			int ch=n0;
			for(int i = 0; i<(N-n0+1); i++) {
				ImpEuler e = new ImpEuler(x0,y0,X,ch);
				double[] ef = e.useImpEuler(x0,y0,X,ch);
				Exact y = new Exact(x0,y0,X,ch);
				double[] yx = y.useExact(x0,y0,X,ch);
				double max = -1;
				for(int j =0;j<ch;j++) {
					if(Math.abs(yx[j]-ef[j])>max) max=Math.abs(yx[j]-ef[j]);
				}
				ans[i]=max;
				ch++;
			}
		}
		if(a==3) {
			int ch = n0;
			for(int i = 0; i<(N-n0+1); i++) {
				RK e = new RK(x0,y0,X,ch);
				double[] ef = e.useRK(x0,y0,X,ch);
				Exact y = new Exact(x0,y0,X,ch);
				double[] yx = y.useExact(x0,y0,X,ch);
				double max = -1;
				for(int j =0;j<ch;j++) {
					if(Math.abs(yx[j]-ef[j])>max) max=Math.abs(yx[j]-ef[j]);
				}
				ans[i]=max;
				ch++;
			}
		}
		
		return ans;
	}
	  public static void main(String[] args) {
		  double[] ansE = getMEr(1,2,5,10,3,1);
		  for(int i = 0; i<ansE.length;i++) {
			  System.out.println(ansE[i]);
		  }
	    }
}
