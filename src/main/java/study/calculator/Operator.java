package study.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", MyNumber::plus),
	MINUS("-", MyNumber::minus),
	MULTIPLY("*", MyNumber::multiply),
	DIVIDED("/", MyNumber::divide)
	;

	private final String operator;
	private final BiFunction<MyNumber, MyNumber, MyNumber> expression;

	Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public MyNumber operate(MyNumber first, MyNumber second) {
		return expression.apply(first, second);
	}

	public static Operator of(String operator) {
		return Arrays.stream(values())
			.filter(o -> o.operator.equals(operator))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

}
