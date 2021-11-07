package study.calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
	PLUS("+", MyNumber::plus),
	MINUS("-", MyNumber::minus),
	MULTIPLY("*", MyNumber::multiply),
	DIVIDED("/", MyNumber::divide)
	;

	private final String operator;
	private final BinaryOperator<MyNumber> expression;

	Operator(String operator, BinaryOperator<MyNumber> expression) {
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
