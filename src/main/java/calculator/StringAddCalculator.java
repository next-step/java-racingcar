package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	static final private String SEPARATOR = ",|:";
	static final private String PATTERN = "//(.)\n(.*)";
	static final private String POSITIVE_PATTERN = "^[0-9]*$";
	static final private Pattern SPECIAL_SEPARATOR_PATTERN = Pattern.compile(PATTERN);

	public static int splitAndSum(String string) {
		if (isBlankOrNull(string)) {
			return 0;
		}
		if (isPositive(string)) {
			return Integer.parseInt(string);
		}
		return getSum(split(string));
	}

	private static int getSum(String[] numbers) {
		int result = 0;
		for (String string : numbers) {
			int stringToNumber = Integer.parseInt(string);
			result += stringToNumber;
			if (!isPositive(string)) {
				throw new RuntimeException();
			}
		}
		return result;
	}

	private static String[] split(String string) {
		Matcher macher = SPECIAL_SEPARATOR_PATTERN.matcher(string);
		if (macher.find()) {
			String customDelimiter = macher.group(1);
			return macher.group(2).split(customDelimiter);
		}
		return string.split(SEPARATOR);
	}

	private static boolean isPositive(String string) {
		return Pattern.matches(POSITIVE_PATTERN, string);
	}

	private static boolean isBlankOrNull(String string) {
		return (string == null || string.isEmpty());
	}

}
