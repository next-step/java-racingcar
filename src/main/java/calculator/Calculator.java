package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String DEFAULT_DELIMITER_CHECK_REGEX = ",|:";
	public static final String CUSTOM_DELIMITER_CHECK_REGEX = "//(.)\n(.*)";
	public static final Pattern CUSTOM_DELIMITER_CHECK_PATTERN = Pattern.compile(CUSTOM_DELIMITER_CHECK_REGEX);


	public String calculate(String input) {
		if ( (input == null) || (input.isEmpty()) ) {
			return "0";
		}

		// 숫자 한개만 입력 시 입력값 그대로 반환
		if (isNumber(input)) {
			return input;
		}

		String[] numbers = separateNumbers(input);

		checkInvalidInput(numbers);

		return sum(numbers).toString();
	}

	private void checkInvalidInput(String[] numbers) {
		for (String number : numbers) {
			validateInputNumber(number);
		}
	}

	private void validateInputNumber(String number) {
		if (isNumber(number) || Integer.valueOf(number) < 0) {
			throw new RuntimeException("음수 or 숫자 이외의 값을 입력하셨습니다.");
		}
	}

	private static String[] separateNumbers(String input) {
		// 구분자 검사
		Matcher m = CUSTOM_DELIMITER_CHECK_PATTERN.matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return input.split(DEFAULT_DELIMITER_CHECK_REGEX);
	}

	private Integer sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}

		return result;
	}

	private boolean isNumber(String input) {
		return input != null && input.matches("[-+]?\\d*\\.?\\d+");
	}

}
