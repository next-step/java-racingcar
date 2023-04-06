package step2_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String DEFAULT_REGEX = "[,:]";
	private static final String CUSTOM_REGEX = "//(.)\n(.*)";

	private static StringAddCalculator stringAddCalculator;

	private StringAddCalculator() {
	}

	public static StringAddCalculator getInstance() {
		if (stringAddCalculator == null) {
			stringAddCalculator = new StringAddCalculator();
		}

		return stringAddCalculator;
	}

	public int splitAndSum(String input) {
		int output = 0;

		if (input != null || input.isEmpty()) {
			return 0;
		}

		String verifyRegex = DEFAULT_REGEX;
		String inputWithoutDelimiter = input;

		if (hasCustomPattern(input)) {

		}

		return output;
	}

	private boolean hasCustomPattern(String input) {
		Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(input);
		return matcher.find();
	}
}
