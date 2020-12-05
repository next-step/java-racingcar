package step2.calculator;

import java.util.Arrays;

public enum OperatorFactory {

	ADDITION(OperatorSign.PLUS, new AdditionOperator());

	private final OperatorSign sign;
	private final Operator operator;

	OperatorFactory(final OperatorSign sign, final Operator operator) {
		this.sign = sign;
		this.operator = operator;
	}

	public static Operator of(final String input) {
		final String SPACE = " ";
		final String[] inputs = input.split(SPACE);
		return findOperator(Arrays.stream(inputs).filter(OperatorSign::isSign)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 없습니다.")));
	}

	private static Operator findOperator(final String sign) {
		return Arrays.stream(OperatorFactory.values())
			.filter(operator -> operator.getSign().equals(sign))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."))
			.getOperator();
	}

	public OperatorSign getSign() {
		return sign;
	}

	public Operator getOperator() {
		return operator;
	}
}
