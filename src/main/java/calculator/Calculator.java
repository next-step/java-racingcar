package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int calc(String input) {
		if (input.isEmpty()) {
			return 0;
		}

		Matcher m = findCustomDelimiter(input);
		if (m.find()) {
			return sum(m.group(2).split(m.group(1)));
		}

		return sum(input.split(DELIMITER));
	}

	private static int sum(String[] values) {
		int sum = 0;
		for (String value : values) {
			sum += Integer.parseInt(value);
		}
		return sum;
	}

	private static Matcher findCustomDelimiter(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input);
	}

}
