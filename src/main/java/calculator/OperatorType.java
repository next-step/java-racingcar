package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum OperatorType {
	ADDITION("+", Integer::sum),
	SUBTRACTION("-", (val1, val2) -> val1 - val2),
	MULTIPLY("*", (val1, val2) -> val1 * val2),
	DIVIDE("/", (val1, val2) -> {
		if (val2 == 0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		return val1 / val2;
	});

	private final String symbol;
	private final BiFunction<Integer, Integer, Integer> expression;

	OperatorType(final String symbol, final BiFunction<Integer, Integer, Integer> expression) {
		this.symbol = symbol;
		this.expression = expression;
	}

	public int calculate(final int num1, final int num2) {
		return expression.apply(num1, num2);
	}

	public static OperatorType getOperatorTypeByCode(final String type) {
		if (Objects.isNull(type) || type.isEmpty()) {
			throw new IllegalArgumentException("계산 문자열이 잘못 되었습니다.");
		}

		return Arrays.stream(OperatorType.values())
				.filter(it -> type.contains(it.symbol))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("연산자가 잘못 되었습니다."));
	}
}
