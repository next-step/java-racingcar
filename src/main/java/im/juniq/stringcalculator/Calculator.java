package im.juniq.stringcalculator;

public class Calculator {
	private static final String SEPARATOR = " ";
	private String input;

	public Calculator(String input) {
		this.input = input;
	}

	public int calculate() {
		String[] terms = input.split(SEPARATOR);
		int result = Integer.valueOf(terms[0]);
		for (int i = 1; i < terms.length - 1; i += 2) {
			result = calculate(result, terms[i], Integer.valueOf(terms[i + 1]));
		}
		return result;
	}

	private int calculate(int leftNumber, String operator, int rightNumber) {
		if ("+".equals(operator)) {
			return Integer.valueOf(leftNumber) + Integer.valueOf(rightNumber);
		}
		throw new IllegalArgumentException();
	}
}
