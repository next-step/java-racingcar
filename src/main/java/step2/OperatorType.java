package step2;

import java.util.Arrays;
import java.util.Optional;
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
		Optional<OperatorType> operatorType = Arrays.stream(values())
			.filter(type -> type.operator.equals(operator))
			.findFirst();

		if (!operatorType.isPresent()) {
			throw new IllegalArgumentException("연산 기호가 잘못됐어요!");
		}

		return operatorType.get();
	}

	public int calculate(int number1, int number2) {
		return calculationMethod.applyAsInt(number1, number2);
	}
}
