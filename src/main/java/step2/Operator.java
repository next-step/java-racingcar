package step2;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
	PLUS("+", (left, right) -> left + right),
	MINUS("-", (left, right) -> left - right),
	MULTIPLY("*", (left, right) -> left * right),
	DIVIDE("/", (left, right) -> left / right);

	private final String sign;
	private final IntBinaryOperator operator;

	Operator(String sign, IntBinaryOperator operator) {
		this.sign = sign;
		this.operator = operator;
	}

	private static final Map<String, Operator> operators = Collections.unmodifiableMap(
		Stream.of(Operator.values())
			.collect(
				Collectors.toMap(operator -> operator.sign, Function.identity())
			)
	);

	public static Operator valueOfSign(String sign) {
		return Optional.ofNullable(operators.get(sign))
			.orElseThrow(() -> new IllegalArgumentException(Message.UNDEFINED_OPERATOR));
	}

	public int operate(int left, int right) {
		return operator.applyAsInt(left, right);
	}
}
