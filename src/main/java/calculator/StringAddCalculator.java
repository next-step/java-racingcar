package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (text == null || text.isBlank()) {
			return 0;
		}
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (matcher.find()) {
			return NumberCalculator.sum(Parser.toNaturalNumbers(split(matcher.group(2), matcher.group(1))));
		}
		return NumberCalculator.sum(Parser.toNaturalNumbers(split(text, ",|:")));
	}

	private static String[] split(String text, String regex) {
		return text.split(regex);
	}
}
