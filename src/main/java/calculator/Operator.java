package calculator;

import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author : byungkyu
 * @date : 2020/12/03
 * @description : 연산자
 **/
public enum Operator {
	PLUS("+", (num1, num2) -> num1 + num2),
	MINUS("-", (num1, num2) -> num1 - num2),
	MULTIPLY("*", (num1, num2) -> num1 * num2),
	DIVIDE("/", (num1, num2) -> num1 / num2);

	private String operator;
	private BiFunction<Integer, Integer, Integer> expression;

	Operator(String s, BiFunction<Integer, Integer, Integer> expression) {
		this.operator = s;
		this.expression = expression;
	}

	public int operate(int num1, int num2) {
		return expression.apply(num1, num2);
	}

	public static Operator of(String arg) {
		return Stream.of(values())
			.filter(op -> op.operator.equals(arg))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("허용된 연산자가 아닙니다."));
	}

}
