package domain;

import dto.CalculateInfo;

public class CommonCalculator implements Calculator{

	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public int divide(int num1, int num2) {
		return num1 / num2;
	}
	
	public int calculate(CalculateInfo calculateInfo) {
		
		if("+".equals(calculateInfo.getOperator())) {
			return add(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("-".equals(calculateInfo.getOperator())) {
			return subtract(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("*".equals(calculateInfo.getOperator())) {
			return multiply(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("/".equals(calculateInfo.getOperator())) {
			return divide(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		return 0;
	}
}
