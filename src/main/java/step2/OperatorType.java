package step2;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperatorType {
	PLUS("+", (number1, number2) -> number1 + number2),
	MINUS("-", (number1, number2) -> number1 - number2),
	MULTIPLY("*", (number1, number2) -> number1 * number2),
	DIVIDE("/", (number1, number2) -> number1 / number2);

	private String operator;
	private BinaryOperator<Integer> expression;

	OperatorType(String operator, BinaryOperator<Integer> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public static OperatorType getByOperator(String operator) {
		return Arrays.stream(values())
			.filter(operatorType -> operatorType.operator.equals(operator))
			.findFirst()
			.get();
	}

	public int calculateByOperator(int number1, int number2) {
		if (operator.equals(DIVIDE.operator) && number2 == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없어요!");
		}
		return expression.apply(number1, number2);
	}
}
