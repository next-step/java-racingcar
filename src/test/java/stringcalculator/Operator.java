package stringcalculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {

	PLUS("+", Integer::sum),
	MINUS("-", (x, y) -> x - y),
	TIMES("*", (x, y) -> x * y),
	DIVISION("/", (x, y) -> x / y);

	private static final String WRONG_SIGN_MESSAGE = "잘못된 연산자입니다.";
	private static final String DIVIDED_BY_ZERO_MESSAGE = "0 으로 나눌 수 없습니다.";

	private final String sign;
	private final IntBinaryOperator intBinaryOperator;

	Operator(String sign, IntBinaryOperator intBinaryOperator) {
		this.sign = sign;
		this.intBinaryOperator = intBinaryOperator;
	}

	/**
	 * 연산자 문자로 Operator 조회
	 *
	 * 요구사항 - 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
	 *
	 * @param sign
	 * @return 연산자 기호에 따른 Operator
	 */
	public static Operator from(String sign) {
		return Arrays.stream(Operator.values())
		             .filter(operator -> operator.sign.equals(sign))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException(WRONG_SIGN_MESSAGE));
	}

	public int calculate(int leftOperand, int rightOperand) {
		if (sign.equals(DIVISION.sign) && rightOperand == 0) {
			throw new IllegalArgumentException(DIVIDED_BY_ZERO_MESSAGE);
		}
		return intBinaryOperator.applyAsInt(leftOperand, rightOperand);
	}


}
