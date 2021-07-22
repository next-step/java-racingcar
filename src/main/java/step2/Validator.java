package step2;

import java.util.Arrays;
import java.util.List;

public class Validator {
	private static List<String> operators = Arrays.asList("+", "-", "*", "/");

	public static void validateExpression(String expression) {
		if (expression == null || expression.trim().isEmpty()) {
			throw new IllegalArgumentException("입력 값이 비어있어요!");
		}
	}

	public static void validateOperator(String operator) {
		if (!operators.contains(operator)) {
			throw new IllegalArgumentException("연산 기호가 잘못됐어요!");
		}
	}
}