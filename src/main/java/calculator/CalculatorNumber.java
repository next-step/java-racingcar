package calculator;

public class CalculatorNumber {
	private int number;
	public CalculatorNumber(int i) {
		number = i;
	}

	public int toInteger() {
		return number;
	}

	public CalculatorNumber add(CalculatorNumber other) {
		return new CalculatorNumber(number + other.toInteger());
	}

	public CalculatorNumber sub(CalculatorNumber other) {
		return new CalculatorNumber(number - other.toInteger());
	}
}
