package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private StringAddCalculator() {
	}

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(("//(.)\n(.*)"));

	public static int splitAndSum(String text) {

		if (text == null || text.isBlank()) {
			return 0;
		}

		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		return sum(split(matcher, text));
	}

	private static String[] split(Matcher matcher, String text) {
		if (matcher.find()){
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return text.split(DEFAULT_DELIMITER);
	}

	private static int sum(String[] values) {

		if (values.length == 1) {
			return new NonNegative(values[0]).toResult();
		}

		NonNegative result = new NonNegative(0);

		for (String value : values) {
			result = result.add(new NonNegative(value));
		}

		return result.toResult();
	}
}
