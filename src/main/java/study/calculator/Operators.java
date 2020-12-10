package study.calculator;

import java.util.Arrays;
import java.util.Optional;

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

	public static Operators mapOperatorStatus(String operator) {
		Operators[] values = Operators.values();
		Optional<Operators> first = Arrays.stream(values)
			.filter(value -> value.token.equals(operator))
			.findFirst();
		return first.orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public int calculate(int src1, int src2) {
		return operator.calculate(src1, src2);
	}
}
