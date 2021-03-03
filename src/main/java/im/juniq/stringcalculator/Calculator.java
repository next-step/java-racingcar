package im.juniq.stringcalculator;

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
		int criterion = Integer.valueOf(terms[0]);
		for (int i = 1; i < terms.length - 1; i += 2) {
			criterion = calculate(criterion, terms[i], Integer.valueOf(terms[i + 1]));
		}
		return criterion;
	}

	private int calculate(int leftNumber, String operator, int rightNumber) {
		return Operator.findByNotation(operator).calculate(leftNumber, rightNumber);
	}

	public enum Operator {
		addition("+"){
			@Override
			public int calculate(int leftNumber, int rightNumber) {
				return leftNumber + rightNumber;
			}
		},
		subtraction("-"){
			@Override
			public int calculate(int leftNumber, int rightNumber) {
				return leftNumber - rightNumber;
			}
		},
		multiplication("*"){
			@Override
			public int calculate(int leftNumber, int rightNumber) {
				return leftNumber * rightNumber;
			}
		},
		division("/"){
			@Override
			public int calculate(int leftNumber, int rightNumber) {
				return leftNumber / rightNumber;
			}
		};

		private String notation;
		public abstract int calculate(int leftNumber, int rightNumber);

		Operator(String notation) {
			this.notation = notation;
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
