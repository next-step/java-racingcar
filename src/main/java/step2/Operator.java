package step2;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	MULTIPLE("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> {
		if (y == 0) {
			throw new IllegalArgumentException();
		}
		return x / y;
	})
	;

	private final String operator;
	private final Calculator calculator;

	Operator(String operator, Calculator calculator) {
		this.operator = operator;
		this.calculator = calculator;
	}

	public static Operator of(String value) {
		return Arrays.stream(values())
		             .filter(o -> o.operator.equals(value))
		             .findFirst()
		             .orElseThrow(IllegalArgumentException::new);
	}

	public String calculate(int num1, int num2) {
		return String.valueOf(calculator.calculate(num1, num2));
	}
}
