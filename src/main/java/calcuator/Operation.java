package calcuator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operation {
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	DIVIDE("/", (x, y) -> x / y),
	MULTIPLY("*", (x, y) -> x * y);

	private final String symbol;
	private final IntBinaryOperator operator;

	private static final Map<String, Operation> CACHED_OPERATION_MAP = Arrays.stream(Operation.values())
		.collect(Collectors.toMap(operation -> operation.symbol, operation -> operation));

	Operation(String symbol, IntBinaryOperator operator) {
		this.symbol = symbol;
		this.operator = operator;
	}

	public static Operation convert(String token) {
		validate(token);
		return CACHED_OPERATION_MAP.get(token);
	}

	private static void validate(String token) {
		if (CACHED_OPERATION_MAP.get(token) == null) {
			throw new IllegalArgumentException("allowed value : [+, -, /, *]");
		}
	}

	public int apply(int left, int right) {
		return operator.applyAsInt(left, right);
	}
}
