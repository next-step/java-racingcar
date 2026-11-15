package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String DELIMITER = ",|:";
	private static String CUSTOM_DELIMITER = "";

	public static int calc(String input) {
		if (input.isEmpty()) {
			return 0;
		}

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			CUSTOM_DELIMITER = m.group(1);

			int sum = 0;
			String[] values = m.group(2).split(CUSTOM_DELIMITER);
			for (String value : values) {
				sum += Integer.parseInt(value);
			}
			return sum;
		}

		String[] values = input.split(DELIMITER);
		int sum = 0;

		for (String value : values) {
			sum += Integer.parseInt(value);
		}

		return sum;
	}

}
