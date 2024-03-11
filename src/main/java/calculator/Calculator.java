package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String DEFAULT_DELIMITER_CHECK_REGEX = ",|:";
	public static final String CUSTOM_DELIMITER_CHECK_REGEX = "//(.)\n(.*)";

	public String calculate(String input) {
		if ( (input == null) || (input.isEmpty()) ) {
			return "0";
		}

		String[] numbers = separateNumbers(input);

		if (numbers.length == 1 && isNumber(numbers[0])) {
			return input;
		}

		return sum(numbers).toString();
	}

	private static String[] separateNumbers(String input) {
		String[] numbers;

		// 구분자 검사
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_CHECK_REGEX).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			numbers = m.group(2).split(customDelimiter);
		} else {
			numbers = input.split(DEFAULT_DELIMITER_CHECK_REGEX);
		}

		return numbers;
	}

	private Integer sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.valueOf(number);
		}

		return result;
	}

	private boolean isNumber(String input) {
		return input != null && input.matches("[-+]?\\d*\\.?\\d+");
	}

}
