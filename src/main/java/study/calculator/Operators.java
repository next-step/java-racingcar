package study.calculator;

public enum Operators implements Operator {
	PLUS("+") {
		@Override
		public int calculate(int x, int y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		public int calculate(int x, int y) {
			return x - y;
		}
	},
	MULTIPLY("*") {
		@Override
		public int calculate(int x, int y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		@Override
		public int calculate(int x, int y) {
			return x / y;
		}
	},
	;

	private String operator;

	Operators(String operator) {
		this.operator = operator;
	}

	public static Operators mapOperatorStatus(String operator) {
		Operators[] values = Operators.values();
		for (Operators value : values) {
			if (value.operator.equals(operator))
				return value;
		}
		throw new IllegalArgumentException();
	}
}
