package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public int additionCalculate(final String input) {
		if (input == null || input.equals("")) {
			return 0;
		}

		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String[] numbers = matcher.group(2).split(customDelimiter);
			return calculateAddition(numbers);
		}

		String[] numbers = input.split(",|:");

		int result = calculateAddition(numbers);

		return result;
	}

	private static int calculateAddition(final String[] number) {
		int result = 0;

		for (int i = 0; i < number.length; i++) {
			result += Integer.parseInt(number[i]);
		}
		return result;
	}
}
