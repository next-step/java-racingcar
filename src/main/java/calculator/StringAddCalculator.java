package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	static final int DEFAULT_NUMBER = 0;
	static final String DEFAULT_SEPARATOR_REGEX = ",|:";
	static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

	public static int splitAndSum(String text) {
		if (text == null || text.isBlank()) {
			return DEFAULT_NUMBER;
		}
		Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
		if (matcher.find()) {
			return NumberCalculator.sum(
				Parser.toNaturalNumbers(split(matcher.group(2), matcher.group(1))));
		}
		return NumberCalculator.sum(
			Parser.toNaturalNumbers(split(text, DEFAULT_SEPARATOR_REGEX)));
	}

	private static String[] split(String text, String regex) {
		return text.split(regex);
	}
}
