package step2;

import java.util.function.IntBinaryOperator;

public enum Operator {
	PLUS("+", (left, right) -> left + right),
	MINUS("-", (left, right) -> left - right),
	MULTIPLY("*", (left, right) -> left * right),
	DIVIDE("/", (left, right) -> left / right);

	private final String stringOperator;
	private final IntBinaryOperator operator;

	Operator(String stringOperator, IntBinaryOperator operator) {
		this.stringOperator = stringOperator;
		this.operator = operator;
	}

	public int operate(int left, int right) {
		return operator.applyAsInt(left, right);
	}
}
