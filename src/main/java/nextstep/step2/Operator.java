package nextstep.step2;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
	PLUS("+", (num1, num2) -> num1 + num2),
	MINUS("-", (num1, num2) -> num1 - num2),
	MULTIPLICATION("*", (num1, num2) -> num1 * num2),
	DIVISION("/", (num1, num2) -> {
		if (num1 % num2 != 0) {
			throw new IllegalArgumentException("divide into integers.");
		}
		return (num1 / num2);
	});

	private final String operator;
	private final BiFunction<Integer, Integer, Integer> operationFunction;

	Operator(String operator, BiFunction<Integer, Integer, Integer> operationFunction) {
		this.operator = operator;
		this.operationFunction = operationFunction;
	}

	public static Operator getOperatorBy(String inputOperator) {
		return Stream.of(values())
				.filter(operator -> operator.operator.equals(inputOperator))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("wrong operator!!"));
	}

	public int apply(int num1, int num2) {
		return operationFunction.apply(num1, num2);
	}
}
