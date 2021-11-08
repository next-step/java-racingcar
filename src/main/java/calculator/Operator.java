package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

	PLUS("+") {
		@Override
		double operate(double first, double second) {
			return first + second;
		}
	},
	MINUS("-") {
		@Override
		double operate(double first, double second) {
			return first - second;
		}
	},
	TIMES("*") {
		@Override
		double operate(double first, double second) {
			return first * second;
		}
	},
	DIVIDE("/") {
		@Override
		double operate(double first, double second) {
			validDivide(second);
			return first / second;
		}
	};

	private final String operand;
	private static final Map<String, Operator> operation;

	// Operator에서 가능한 연산 기호를 put 한다
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

	abstract double operate(double first, double second);

	public static Operator operation(String inputOperand) {
		// input으로 들어온 연산이없으면 Exception이 발생한다
		if (!operation.containsKey(inputOperand)) {
			throw new IllegalArgumentException("존재하지 않은 연산입니다.");
		}

		// input으로 들어온 연산을 return
		return operation.get(inputOperand);
	}

	private static void validDivide(double second) {
		if (second == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다");
		}
	}
}
