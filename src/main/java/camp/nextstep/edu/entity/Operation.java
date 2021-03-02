package camp.nextstep.edu.entity;

import java.util.Arrays;
import java.util.function.BiFunction;

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

	public static int getResult(int prev, int current, String op) {
		BiFunction<Integer, Integer, Integer> exactOperation = Arrays.stream(values())
				.filter(oper -> oper.op.equals(op))
				.findFirst()
				.get()
				.operation;

		return exactOperation.apply(prev, current);
	}
}
