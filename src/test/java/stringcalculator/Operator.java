package stringcalculator;

import java.util.function.IntBinaryOperator;

public enum Operator {

	PLUS("+", Integer::sum);

	private final String sign;
	private final IntBinaryOperator intBinaryOperator;

	Operator(String sign, IntBinaryOperator intBinaryOperator) {
		this.sign = sign;
		this.intBinaryOperator = intBinaryOperator;
	}

	public int calculate(int x, int y) {
		return intBinaryOperator.applyAsInt(x, y);
	}


}
