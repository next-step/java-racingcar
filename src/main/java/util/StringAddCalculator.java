package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String DELIMITER_PATTERN_STRING = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");

	public StringAddCalculator() {
	}

	public int calculate(String input) {
		if(isNotValid(input)) {
			return 0;
		}

		String[] numbers = splitByCustomDelimiter(input);

		if(isNotValid(numbers)) {
			return Integer.parseInt(input);
		}

		return getSum(numbers);
	}

	private String[] splitByCustomDelimiter(String input) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

		if(matcher.find()) {
			return matcher.group(2).split(DELIMITER_PATTERN_STRING + "|" + matcher.group(1));
		}

		return input.split(DELIMITER_PATTERN_STRING);
	}

	private boolean isNotValid(String input) {
		if(input == null || input.isBlank()) {
			return true;
		}

		return false;
	}


	private boolean isNotValid(String[] numbers) {
		if(numbers.length <= 1) {
			return true;
		}

		return false;
	}

	private void checkPositive(int number) {
		if(number < 0) {
			throw new RuntimeException("음수가 포함되어 있습니다.");
		}
	}

	private int getSum(String[] numbers) {
		int sum = 0;

		for(String number : numbers) {
			int num = Integer.parseInt(number);
			checkPositive(num);
			sum += num;
		}

		return sum;
	}
}
