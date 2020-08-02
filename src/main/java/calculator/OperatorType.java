package calculator;

import java.util.Objects;

public enum OperatorType {
	PLUS("+", new AddOperator()),
	MINUS("-", new SubtractOperator()),
	DIVIDE("/", new DivideOperator()),
	MULTIPLY("*", new MultiplyOperator());

	private final String type;
	private final Operator operator;

	public String getType() {
		return type;
	}

	public Operator getOperator() {
		return operator;
	}

	OperatorType(final String type, final Operator operator) {
		this.type = type;
		this.operator = operator;
	}

	public static OperatorType getOperatorTypeByCode(final String type) {
		if(Objects.isNull(type) || type.isEmpty()) {
			throw new IllegalArgumentException("계산 문자열이 잘못 되었습니다.");
		}

		for(final OperatorType operatorType : values()) {
			if(type.equals(operatorType.getType())) {
				return operatorType;
			}
		}

		throw new IllegalArgumentException("연산자가 잘못 되었습니다.");
	}
}
