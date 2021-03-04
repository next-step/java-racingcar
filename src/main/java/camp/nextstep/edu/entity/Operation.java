package camp.nextstep.edu.entity;

import java.util.Arrays;
import java.util.function.BiFunction;

import camp.nextstep.edu.exception.UserException;

public enum Operation {
	PLUS("+", (acc, cur) -> acc + cur),
	MINUS("-", (acc, cur) -> acc - cur),
	DIVIDE("/", (acc, cur) -> acc / cur),
	MULTIPLY("*", (acc, cur) -> acc * cur);
	private final String op;
	private final BiFunction<Integer, Integer, Integer> operation;

	Operation(String op, BiFunction<Integer, Integer, Integer> operation) {
		this.op = op;
		this.operation = operation;
	}

	public BiFunction<Integer, Integer, Integer> getOperation() {
		return operation;
	}

	public static Operation getInstance(String inputOp) {
		return Arrays.stream(values())
			.filter(oper -> oper.op.equals(inputOp))
			.findFirst()
			.orElseThrow(UserException::new);
	}

	public static boolean isOperation(String inputOp) {
		return Arrays.stream(values())
			.anyMatch(oper -> oper.op.equals(inputOp));
	}
}
