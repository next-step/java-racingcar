package im.juniq.stringcalculator;

import java.util.function.BinaryOperator;

public class Calculator {
	private static final String SEPARATOR = " ";
	private String input;

	public Calculator(String input) {
		this.input = input;
	}

	public int run() {
		validInputIsNullAndBlank();
		String[] terms = extractToTerms(input);
		return calculateEachTerm(terms);
	}

	private void validInputIsNullAndBlank() {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException();
		}
	}

	private String[] extractToTerms(String input) {
		return input.split(SEPARATOR);
	}

	private int calculateEachTerm(String[] terms) {
		int criterion = Integer.parseInt(terms[0]);
		for (int i = 1; i < terms.length - 1; i += 2) {
			criterion = calculate(criterion, terms[i], Integer.parseInt(terms[i + 1]));
		}
		return criterion;
	}

	private int calculate(int leftNumber, String operator, int rightNumber) {
		return Operator.findByNotation(operator).calculate.apply(leftNumber, rightNumber);
	}

	private enum Operator {
		ADDITION("+", (leftNumber, rightNumber) -> leftNumber + rightNumber),
		SUBTRACTION("-", (leftNumber, rightNumber) -> leftNumber - rightNumber),
		MULTIPLICATION("*", (leftNumber, rightNumber) -> leftNumber * rightNumber),
		DIVISION("/", (leftNumber, rightNumber) -> leftNumber / rightNumber);

		private String notation;
		private BinaryOperator<Integer> calculate;

		Operator(String notation, BinaryOperator<Integer> calculate) {
			this.notation = notation;
			this.calculate = calculate;
		}

		public static Operator findByNotation(String notation) {
			for (Operator operator: Operator.values()) {
				if(operator.notation.equals(notation))
					return operator;
			}
			throw new IllegalArgumentException();
		}
	}
}
