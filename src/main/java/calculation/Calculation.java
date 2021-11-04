package calculation;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculation {
	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTIPLICATION("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> {
		checkZeroNumber(b);
		return a / b;
	});

	private static final String DIVISION_ERROR_MESSAGE = "error : 0으로 나눌수 없습니다.";
	private static final String OPERATOR_ERROR_MESSAGE = "error : 올바른 연산자가 아닙니다.";
	private String operator;
	private BiFunction<Integer, Integer, Integer> calculateValue;

	Calculation(String operator, BiFunction<Integer, Integer, Integer> calculateValue) {
		this.operator = operator;
		this.calculateValue = calculateValue;
	}

	public static int calculate(String operator, int firstNumber, int lastNumber) {
		return findValidOperator(operator).calculateValue.apply(firstNumber, lastNumber);
	}

	private static Calculation findValidOperator(String operator) {
		return Arrays.stream(values())
			.filter(i -> i.operator.equals(operator))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(OPERATOR_ERROR_MESSAGE));
	}

	private static void checkZeroNumber(int lastNumber) {
		if (lastNumber == 0) {
			throw new IllegalArgumentException(DIVISION_ERROR_MESSAGE);
		}
	}

}
