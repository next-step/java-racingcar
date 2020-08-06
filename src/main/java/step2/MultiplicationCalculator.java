package step2;

public class MultiplicationCalculator implements Calculator {

	@Override
	public boolean isValidOperator(String operator) {
		return "*".equals(operator);
	}

	@Override
	public int calculate(int num1, int num2) {
		return num1 * num2;
	}
}
