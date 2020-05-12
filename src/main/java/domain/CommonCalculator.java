package domain;

import dto.CalculateInfo;

public class CommonCalculator implements Calculator{

	public int add(int num1, int num2) {
		return num1+num2;
	}

	public int subStract(int num1, int num2) {
		return num1-num2;
	}
	
	public int multifly(int num1, int num2) {
		return num1*num2;
	}
	
	public int devide(int num1, int num2) {
		return num1/num2;
	}
	
	public int calculate(CalculateInfo calculateInfo) {
		
		if("+".equals(calculateInfo.getOperator())) {
			return add(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("-".equals(calculateInfo.getOperator())) {
			return subStract(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("*".equals(calculateInfo.getOperator())) {
			return multifly(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("/".equals(calculateInfo.getOperator())) {
			return devide(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		return 0;
	}
}
