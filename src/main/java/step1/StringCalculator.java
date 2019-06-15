package step1;

import java.util.Scanner;

public class StringCalculator {
	static Calculator cal;
	static String[] operator = {"+", "-", "*", "/"};
	
	public static void main(String[] args) {
		String[] exp = getInput().split(" ");
		
		Double result = doRecursiveCalculate(exp);
		
		System.out.println(result);
	}
	
	public static String getInput() {
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if(input.isEmpty()) throw new IllegalArgumentException();
        
        return input;
	}

	public static double doRecursiveCalculate(String[] exp) {
		if(exp==null) throw new IllegalArgumentException();
        if(exp[0]==null) throw new IllegalArgumentException();
        if(exp.length<=1) throw new IllegalArgumentException();
        
		double result = 0;
		
		cal = new Calculator();	
		switch(exp[1]) {
			case "+":
				result = cal.doPlus(exp[0], exp[2]);
				break;
			case "-":
				result = cal.doMinus(exp[0], exp[2]);
				break;
			case "*":
				result = cal.doMultiple(exp[0], exp[2]);
				break;
			case "/":
				result = cal.doDevide(exp[0], exp[2]);
				break;
			default:
				throw new IllegalArgumentException();					
		}

		if(exp.length>3) {	
			exp = newExp(result, exp);
			
			return doRecursiveCalculate(exp);
		}
		
		return result;
		
	}
	
	public static String[] newExp(double val, String[] exp) {
		String[] newExp = new String[exp.length-2];
		newExp[0] = Double.toString(val);
		
		for(int i=0 ; i<newExp.length-1; i++) {
			newExp[i+1] = exp[i+3];
		}
		
		return newExp;
	}
}