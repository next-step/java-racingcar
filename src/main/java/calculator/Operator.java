package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum Operator {

	PLUS("+", (first, second) -> first + second),
	MINUS("-", (first, second) -> first - second),
	TIMES("*", (first, second) -> first * second),
	DIVIDE("/", (first, second) -> {
		validDivide(second);
		return first / second;
	});

	private final String operand;
	private final IntBinaryOperator result;
	private static final Map<String, Operator> operation;

	static {
		operation = new HashMap<>();
		for (Operator op : Operator.values()) {
			operation.put(op.value(), op);
		}
	}

	Operator(String operand, IntBinaryOperator result) {
		this.operand = operand;
		this.result = result;
	}

	public String value() {
		return operand;
	}

	public int operate(int first, int second) {
		return result.applyAsInt(first, second);
	}

	public static Operator operation(String inputOperand) {
		if (!operation.containsKey(inputOperand)) {
			throw new IllegalArgumentException("존재하지 않은 연산입니다.");
		}
		return operation.get(inputOperand);
	}

	private static void validDivide(double second) {
		if (second == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다");
		}
	}
}
