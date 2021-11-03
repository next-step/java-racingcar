package calculation;

import java.util.regex.Pattern;

public class Number {
	private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 연산자 앞 뒤는 아라비아 숫자만 사용가능합니다.";
	private static final String EMPTY = "";
	private static final String NUMBER_PATTERN = "^[0-9]*$";
	private static final String OPERATOR_PATTERN = "[-/*+]";

	public Number() {
	}

	public static int findFirstNumber(Data data, int number, int operatorIndex) {
		if (number == 0) {
			return firstNumber(data, operatorIndex);
		}
		return number;
	}

	private static int firstNumber(Data data, int operatorIndex) {
		String number = EMPTY;
		for (int i = 0; i < operatorIndex; i++) {
			number += data.value(i);
		}

		checkNumberType(number);

		return changeToStringInteger(number);
	}

	public static int lastNumber(Data data, int operatorIndex) {
		String number = EMPTY;
		for (int i = operatorIndex + 1; i < data.size(); i++) {
			if (Pattern.matches(OPERATOR_PATTERN, data.value(i))) {
				break;
			}
			number += data.value(i);
		}

		checkNumberType(number);

		return changeToStringInteger(number);
	}

	private static void checkNumberType(String number) {
		boolean result = !Pattern.matches(NUMBER_PATTERN, number);
		if (result) {
			throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static int changeToStringInteger(String number) {
		return Integer.parseInt(number);
	}
}
