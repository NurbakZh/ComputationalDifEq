package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.solutions.Euler;
import application.solutions.Exact;
import application.solutions.GTE;
import application.solutions.ImpEuler;
import application.solutions.MaxError;
import application.solutions.RK;
import application.solutions.Solutions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
	
    @FXML
    private LineChart<?, ?> Chart3;

    @FXML
    private NumberAxis xaxis3;

    @FXML
    private NumberAxis yaxis3;

    @FXML
    private Button compButton;

    @FXML
    private TextField x0;

    @FXML
    private TextField N;

    @FXML
    private TextField X;

    @FXML
    private TextField y0;

    @FXML
    private LineChart<?, ?> Chart1;
    
    @FXML
    private NumberAxis xaxis1;

    @FXML
    private NumberAxis yaxis1;
   
    @FXML
    private LineChart<?, ?> Chart2;

    @FXML
    private NumberAxis xaxis2;

    @FXML
    private NumberAxis yaxis2;

    @FXML
    private TextField Nmin;

    @FXML
    private TextField Nmax;

    @FXML
    private Button compButton2;
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		GTE g = new GTE();
		MaxError m = new MaxError();
        Solutions a = new Solutions(1,2,5,2);
        Exact a1 = new Exact(1,2,5,2);
        Euler a2 = new Euler(1,2,5,2);
        ImpEuler a3 = new ImpEuler(1,2,5,2);
        RK a4 = new RK(1,2,5,2);
        double[] y =  a2.useEuler(1,2,5,2);
        double[] yI =  a3.useImpEuler(1,2,5,2);
        double[] yR =  a4.useRK(1,2,5,2);
        double[] yE = a1.useExact(1,2,5,2);
        double[] x = a.getX();
        double[] ansE = m.getMEr(1,2,5,2,1,1);
        double[] ansI = m.getMEr(1,2,5,2,1,2);
        double[] ansR = m.getMEr(1,2,5,2,1,3);
		x0.setText("1");
    	y0.setText("2");
    	X.setText("5");
    	N.setText("2");
    	Nmin.setText("1");
    	Nmax.setText("2");
		XYChart.Series series1 = new XYChart.Series<>();
		series1.setName("Euler");
		XYChart.Series series1I = new XYChart.Series<>();
		series1I.setName("Improved Euler");
		XYChart.Series series1R = new XYChart.Series<>();
		series1R.setName("Runge-Kutta");
		XYChart.Series series1E = new XYChart.Series<>();
		series1E.setName("Exact");
		XYChart.Series seriesGE = new XYChart.Series<>();
		seriesGE.setName("Euler");
		XYChart.Series seriesGI = new XYChart.Series<>();
		seriesGI.setName("Improved Euler");
		XYChart.Series seriesGR = new XYChart.Series<>();
		seriesGR.setName("Runge-Kutta");
		XYChart.Series seriesaE = new XYChart.Series<>();
		seriesaE.setName("Euler");
		XYChart.Series seriesaI = new XYChart.Series<>();
		seriesaI.setName("Improved Euler");
		XYChart.Series seriesaR = new XYChart.Series<>();
		seriesaR.setName("Runge-Kutta");
		for(int i = 0; i <= 2; i++) {
			series1.getData().add(new XYChart.Data(x[i],y[i]));
			series1I.getData().add(new XYChart.Data(x[i],yI[i]));
			series1R.getData().add(new XYChart.Data(x[i],yR[i]));
			series1E.getData().add(new XYChart.Data(x[i],yE[i]));
			seriesGE.getData().add(new XYChart.Data(x[i],g.countError(y[i],yE[i])));
			seriesGI.getData().add(new XYChart.Data(x[i],g.countError(yI[i],yE[i])));
			seriesGR.getData().add(new XYChart.Data(x[i],g.countError(yR[i],yE[i])));	
		}
		for(int j = 0; j < ansE.length; j++) {
			seriesaE.getData().add(new XYChart.Data(j+1,ansE[j]));
			seriesaI.getData().add(new XYChart.Data(j+1,ansI[j]));
			seriesaR.getData().add(new XYChart.Data(j+1,ansR[j]));
		}
	    Chart1.getData().addAll(series1,series1I,series1R,series1E);
	    Chart1.setCreateSymbols(false);
	    Chart3.getData().addAll(seriesGE,seriesGI,seriesGR);
	    Chart3.setCreateSymbols(false);
	    Chart2.getData().addAll(seriesaE,seriesaI,seriesaR);
	    Chart2.setCreateSymbols(false);
	      
	    	compButton.setOnAction(event -> {
	    		XYChart.Series series2 = new XYChart.Series<>();
	    		series2.setName("Euler");
	    		XYChart.Series series2I = new XYChart.Series<>();
	    		series2I.setName("Improved Euler");
	    		XYChart.Series series2R = new XYChart.Series<>();
	    		series2R.setName("Runge-Kutta");
	    		XYChart.Series series2E = new XYChart.Series<>();
	    		series2E.setName("Exact");
	    		XYChart.Series seriesGE2 = new XYChart.Series<>();
	    		seriesGE2.setName("Euler");
	    		XYChart.Series seriesGI2 = new XYChart.Series<>();
	    		seriesGI2.setName("Improved Euler");
	    		XYChart.Series seriesGR2 = new XYChart.Series<>();
	    		seriesGR2.setName("Runge-Kutta");
	    		XYChart.Series seriesaE2 = new XYChart.Series<>();
	    		seriesaE2.setName("Euler");
	    		XYChart.Series seriesaI2 = new XYChart.Series<>();
	    		seriesaI2.setName("Improved Euler");
	    		XYChart.Series seriesaR2 = new XYChart.Series<>();
	    		seriesaR2.setName("Runge-Kutta");
	    		int n1 = Integer.parseInt(N.getText());
	    		double x1 = Integer.parseInt(x0.getText());
	    		double y1 = Integer.parseInt(y0.getText());
	    		double X1 = Integer.parseInt(X.getText());
	    		int nmi = Integer.parseInt(Nmin.getText());
	    		int nma = Integer.parseInt(Nmax.getText());
	    		Solutions ne = new Solutions(x1,y1,X1,n1);
	    		double[] y11 =  a2.useEuler(x1,y1,X1,n1);
	    		double[] y11I =  a3.useImpEuler(x1,y1,X1,n1);
	    		double[] y11R =  a4.useRK(x1,y1,X1,n1);
	    		double[] y11E =  a1.useExact(x1,y1,X1,n1);
	            double[] x11 = new double[n1+1];
	            x11[0]=x1;
	            for(int i = 1; i<x11.length; i++) {
	            	x11[i]=x11[i-1]+((X1-x1)/n1);
	            }
	            double[] ansE1 = m.getMEr(x1,y1,X1,nma,nmi,1);
	            double[] ansI1 = m.getMEr(x1,y1,X1,nma,nmi,2);
	            double[] ansR1 = m.getMEr(x1,y1,X1,nma,nmi,3);
	    		for(int i = 0; i <= n1; i++) {
	    			series2.getData().add(new XYChart.Data(x11[i],y11[i]));
	    			series2I.getData().add(new XYChart.Data(x11[i],y11I[i]));
	    			series2R.getData().add(new XYChart.Data(x11[i],y11R[i]));
	    			series2E.getData().add(new XYChart.Data(x11[i],y11E[i]));
	    			seriesGE2.getData().add(new XYChart.Data(x11[i],g.countError(y11[i],y11E[i])));
	    			seriesGI2.getData().add(new XYChart.Data(x11[i],g.countError(y11I[i],y11E[i])));
	    			seriesGR2.getData().add(new XYChart.Data(x11[i],g.countError(y11R[i],y11E[i])));
	    		}
	    		for(int j = 0; j < ansE1.length; j++) {
	    			seriesaE2.getData().add(new XYChart.Data(j+nmi,ansE1[j]));
	    			seriesaI2.getData().add(new XYChart.Data(j+nmi,ansI1[j]));
	    			seriesaR2.getData().add(new XYChart.Data(j+nmi,ansR1[j]));
	    		}
	    		Chart1.getData().clear();
	    		Chart1.getData().addAll(series2,series2I,series2R,series2E);
	    		Chart3.getData().clear();
	    		Chart3.getData().addAll(seriesGE2,seriesGI2,seriesGR2);
	    		Chart2.getData().clear();
	    		Chart2.getData().addAll(seriesaE2,seriesaI2,seriesaR2);
	    	});
	    	
	    	compButton2.setOnAction(event-> {
	    		XYChart.Series seriesaE2 = new XYChart.Series<>();
	    		seriesaE2.setName("Euler");
	    		XYChart.Series seriesaI2 = new XYChart.Series<>();
	    		seriesaI2.setName("Improved Euler");
	    		XYChart.Series seriesaR2 = new XYChart.Series<>();
	    		seriesaR2.setName("Runge-Kutta");
	    		int n1 = Integer.parseInt(N.getText());
	    		double x1 = Integer.parseInt(x0.getText());
	    		double y1 = Integer.parseInt(y0.getText());
	    		double X1 = Integer.parseInt(X.getText());
	    		int nmi = Integer.parseInt(Nmin.getText());
	    		int nma = Integer.parseInt(Nmax.getText());
	    		double[] ansE1 = m.getMEr(x1,y1,X1,nma,nmi,1);
		        double[] ansI1 = m.getMEr(x1,y1,X1,nma,nmi,2);
		        double[] ansR1 = m.getMEr(x1,y1,X1,nma,nmi,3);
	    		for(int j = 0; j < ansE1.length; j++) {
	    			seriesaE2.getData().add(new XYChart.Data(j+nmi,ansE1[j]));
	    			seriesaI2.getData().add(new XYChart.Data(j+nmi,ansI1[j]));
	    			seriesaR2.getData().add(new XYChart.Data(j+nmi,ansR1[j]));
	    		}
	    		Chart2.getData().clear();
	    		Chart2.getData().addAll(seriesaE2,seriesaI2,seriesaR2);
	    	});
	}

}
