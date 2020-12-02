package calculator.helper;

import calculator.Operator;

public class OperatorFactorHelper {

	public static boolean isOperatorFactor(String value) {
		return Operator.isContainsMathOperator(value);
	}

}
