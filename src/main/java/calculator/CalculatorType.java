package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum CalculatorType {

	PLUS("+", (num1, num2) -> num1 + num2),
	MINUS("-", (num1, num2) -> num1 - num2),
	MULTI("*", (num1, num2) -> num1 * num2),
	MOD("/", (num1, num2) -> num1 / num2);

	private final String operator;

	// Java8 에서 추가된 BiFunction
	// 앞의 두개의 타입 파라메터를 받고, 세번재 타입으로 리턴하는 메서드
	private final BiFunction<Integer, Integer, Integer> expression;

	CalculatorType(String operator, BiFunction<Integer, Integer, Integer> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public Integer calculate(Integer num1, Integer num2) {
		return this.expression.apply(num1, num2);
	}

	public static CalculatorType getOperator(String operator) {

		// stream(enum.values)
		return Arrays.stream(values())
			// filter 는 요소를 특정 기준으로 필터링
			// Enum 객체에 설정한 operator 문자열과 비교
			.filter(o -> o.operator.equals(operator))
			// findFirst // findAny
			.findFirst()
			// filter 메소드에 탐색이 안되면 Exception throw
			.orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
	}
}
