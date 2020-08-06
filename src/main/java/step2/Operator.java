package step2;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	MULTIPLE("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y)
	;

	private final String operator;
	private final Op op;

	Operator(String operator, Op op) {
		this.operator = operator;
		this.op = op;
	}

	public static Operator of(String value) {
		Optional<Operator> maybeOperator = Arrays.stream(values()).filter(o -> o.operator.equals(value)).findFirst();
		return maybeOperator.orElseThrow(IllegalArgumentException::new);
	}

	public String calculate(int num1, int num2) {
		return String.valueOf(op.calculate(num1, num2));
	}
}
