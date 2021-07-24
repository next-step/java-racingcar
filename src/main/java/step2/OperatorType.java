package step2;

import static step2.Validator.*;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum OperatorType {
	PLUS("+", Integer::sum),
	MINUS("-", (number1, number2) -> number1 - number2),
	MULTIPLY("*", (number1, number2) -> number1 * number2),
	DIVIDE("/", (number1, number2) -> {
		if (number2 == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없어요!");
		}
		return number1 / number2;
	});

	private String operator;
	private IntBinaryOperator calculationMethod;

	OperatorType(String operator, IntBinaryOperator calculationMethod) {
		this.operator = operator;
		this.calculationMethod = calculationMethod;
	}

	public static OperatorType getByOperator(String operator) {
		validateOperator(operator);

		return Arrays.stream(values())
			.filter(operatorType -> operatorType.operator.equals(operator))
			.findFirst()
			.get();
	}

	public int calculateByOperator(int number1, int number2) {
		return calculationMethod.applyAsInt(number1, number2);
	}
}
