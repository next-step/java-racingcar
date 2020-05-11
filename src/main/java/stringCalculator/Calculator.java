package stringCalculator;

public class Calculator implements ICalculator{

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
}
