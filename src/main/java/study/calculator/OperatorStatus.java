package study.calculator;

public enum OperatorStatus {
	PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

	private String operator;

	OperatorStatus(String operator) {
		this.operator = operator;
	}

	public static OperatorStatus mapOperatorStatus(String operator) {
		if (operator.equals("+"))
			return PLUS;
		if (operator.equals("-"))
			return MINUS;
		if (operator.equals("*"))
			return MULTIPLY;
		if (operator.equals("/"))
			return DIVIDE;
		throw new IllegalArgumentException();
	}

	public boolean isNotPlus() {
		return this != PLUS;
	}

	public boolean isNotMinus() {
		return this != MINUS;
	}

	public boolean isNotMultiply() {
		return this != MULTIPLY;
	}

	public boolean isNotDivide() {
		return this != DIVIDE;
	}
}
