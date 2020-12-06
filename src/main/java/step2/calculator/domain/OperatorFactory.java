package step2.calculator.domain;

import java.util.Arrays;

public enum OperatorFactory {

	ADDITION(new AdditionOperator()),
	SUBTRACTION(new SubtractionOperator()),
	MULTIPLICATION(new MultiplicationOperator()),
	DIVISION(new DivisionOperator());

	public final static String INPUT_DELIMITER = " ";
	private final Operator operator;

	OperatorFactory(final Operator operator) {
		this.operator = operator;
	}
	public static Operator findOperator(final String sign) {
		return Arrays.stream(OperatorFactory.values())
			.filter(operator -> operator.getOperator().getSign().equals(sign))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."))
			.getOperator();
	}

	public Operator getOperator() {
		return operator;
	}

}
