package study.calculator;

import java.util.Arrays;

public enum Operators implements Operator {
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	MULTIPLY("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);

	private final String token;
	private final Operator operator;

	Operators(String token, Operator operator) {
		this.token = token;
		this.operator = operator;
	}

	public static Operators mapOperatorStatus(String token) {
		return Arrays.stream(Operators.values())
			.filter(operator -> operator.isEquals(token))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	private boolean isEquals(String token) {
		return this.token.equals(token);
	}

	@Override
	public int calculate(int src1, int src2) {
		return operator.calculate(src1, src2);
	}
}
