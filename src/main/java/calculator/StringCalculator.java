package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DELIMITERS = ",|:";
	private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
	// 외부에 공개될 필요가 없을 때
	// public -> private

	public static int splitAndSum(String input) {
		if (isNullOrBlank(input)) {
			return 0;
		}

		return sumNumbers(removeDelimiter(input));
	}

	private static String[] removeDelimiter(String input) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return input.split(DELIMITERS);
	}

	private static boolean isNullOrBlank(String input) {
		return input == null || input.isEmpty();
	}

	private static int sumNumbers(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			int num = Integer.parseInt(number);
			if(num < 0) {
				throw new RuntimeException();
			}
			sum += num;
		}
		return sum;
	}
}
