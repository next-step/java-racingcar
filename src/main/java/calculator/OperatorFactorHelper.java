package calculator;

public class OperatorFactorHelper {

	public static boolean isOperatorFactor(String value) {
		return Operator.isContainsMathOperator(value);
	}

}
