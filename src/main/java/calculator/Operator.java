package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
	MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
	TIMES("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
	DIVIDE("/", (firstNumber, secondNumber) -> {
		checkZeroDivide(secondNumber);
		return firstNumber / secondNumber;
	});

	private final String operator;
	private final BiFunction<Integer, Integer, Integer> function;

	Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
		this.operator = operator;
		this.function = function;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return this.function.apply(firstNumber, secondNumber);
	}

	private static void checkZeroDivide(int secondNumber) {
		if (secondNumber == 0) {
			throw new IllegalArgumentException();
		}
	}

	public static Operator valueOfOperator(String symbol) {
		return Arrays.stream(Operator.values())
			.filter(operator -> operator.operator.equals(symbol))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}
