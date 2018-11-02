package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by hspark on 02/11/2018.
 */
public enum Operator {
	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTI("*", (a, b) -> a * b),
	SUB("/", (a, b) -> a / b);

	private String operator;
	private BiFunction<Integer, Integer, Integer> calculator;

	Operator(String operators, BiFunction<Integer, Integer, Integer> calculator) {
		this.operator = operators;
		this.calculator = calculator;
	}

	public static Operator findOperator(String operatorStr) {
		return Arrays.stream(Operator.values())
			.filter(operator -> operator.equalToString(operatorStr))
			.findFirst().orElse(null);
	}

	public int calculate(int a, int b){
		return calculator.apply(a, b);
	}

	private boolean equalToString(String str) {
		return this.operator.equals(str);
	}
}

