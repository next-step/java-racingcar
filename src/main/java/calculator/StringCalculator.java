package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int cal(String input) {
		int result = 0;

		if (input == null || input.isEmpty()) {
			return 0;
		}

		if (input.contains("-")) {
			throw new RuntimeException();
		}

		if (input.contains(",") || input.contains(":")) {
			String[] numbers = input.split(",|:");
			return sumInput(numbers);
		}

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens= m.group(2).split(customDelimiter);
			return sumInput(tokens);
		}
		return Integer.parseInt(input);
	}

	private static int sumInput(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
