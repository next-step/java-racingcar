package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

	PLUS("+") {
		@Override
		int operate(int first, int second) {
			return first + second;
		}
	},
	MINUS("-") {
		@Override
		int operate(int first, int second) {
			return first - second;
		}
	},
	TIMES("*") {
		@Override
		int operate(int first, int second) {
			return first * second;
		}
	},
	DIVIDE("/") {
		@Override
		int operate(int first, int second) {
			validDivide(second);
			return first / second;
		}
	};

	private final String operand;
	private static final Map<String, Operator> operation;

	static {
		operation = new HashMap<>();
		for (Operator op : Operator.values()) {
			operation.put(op.value(), op);
		}
	}

	Operator(String operand) {
		this.operand = operand;
	}

	public String value() {
		return operand;
	}

	abstract int operate(int first, int second);

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
