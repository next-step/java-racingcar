package step1;

public class Calculator {
	
    public double doPlus(String a, String b) {
    	double x = Double.parseDouble(a);
    	double y = Double.parseDouble(b);
    	
        return x+y;
    }
	
    public double doMinus(String a, String b) {
    	double x = Double.parseDouble(a);
    	double y = Double.parseDouble(b);
    	
        return x-y;
    }
	
    public double doMultiple(String a, String b) {
    	double x = Double.parseDouble(a);
    	double y = Double.parseDouble(b);
    	
        return x*y;
    }
	
    public double doDevide(String a, String b) {
    	double x = Double.parseDouble(a);
    	double y = Double.parseDouble(b);
    	
        return x/y;
    }
}
