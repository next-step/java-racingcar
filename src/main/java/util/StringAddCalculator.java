package util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String DELIMITER_PATTERN = ",|:";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\n(.*)";

	public StringAddCalculator() {
	}

	public int calculate(String input) {
		if(isNotValidInput(input)) {
			return 0;
		}

		String[] numbers = splitByCustomDelimiter(input);

		if(isNotValidNumbers(numbers)) {
			return Integer.parseInt(input);
		}

		return getSum(numbers);
	}

	public String[] splitByCustomDelimiter(String input) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

		if(matcher.find()) {
			return matcher.group(2).split(DELIMITER_PATTERN + "|" + matcher.group(1));
		}

		return input.split(DELIMITER_PATTERN);
	}

	private boolean isNotValidInput(String input) {
		if(input == null) {
			return true;
		}

		if(input.trim().isEmpty()) {
			return true;
		}

		return false;
	}


	private boolean isNotValidNumbers(String[] numbers) {
		if(numbers.length <= 1) {
			return true;
		}

		return false;
	}

	private void isNotValidNumber(int number) {
		if(number < 0) {
			throw new RuntimeException("음수가 포함되어 있습니다.");
		}
	}

	private int getSum(String[] numbers) {
		return Arrays.stream(numbers)
				.mapToInt(Integer::parseInt)
				.peek(this::isNotValidNumber)
				.sum();
	}
}
