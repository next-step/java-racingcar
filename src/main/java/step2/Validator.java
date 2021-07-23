package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
	private static List<String> operators = Arrays.asList("+", "-", "*", "/");
	private static String numberRegex = "^[0-9]*$";

	public static void validateEmpty(String expression) {
		if (expression == null || expression.trim().isEmpty()) {
			throw new IllegalArgumentException("입력 값이 비어있어요!");
		}
	}

	public static void validateOperator(String operator) {
		if (!operators.contains(operator)) {
			throw new IllegalArgumentException("연산 기호가 잘못됐어요!");
		}
	}

	public static void validateNumber(String number) {
		if (number == null || number.isEmpty()) {
			throw new NumberFormatException("숫자 형식이 잘못됐어요!");
		}

		if (!Pattern.matches(numberRegex, number)) {
			throw new NumberFormatException("숫자 형식이 잘못됐어요!");
		}
	}
}