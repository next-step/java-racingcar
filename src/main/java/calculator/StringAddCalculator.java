package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	static final private String SEPARATOR = ",|:";
	static final private String PATTERN = "//(.)\n(.*)";
	static final private String POSITIVE_PATTERN = "^[0-9]*$";
	static final private Pattern SPECIAL_SEPARATOR_PATTERN = Pattern.compile(PATTERN);

	public static int splitAndSum(String str) {
		if (isBlankOrNull(str)) {
			return 0;
		}
		if (isPositive(str)) {
			return Integer.parseInt(str);
		}
		return getSum(split(str));
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

	private static String[] split(String str) {
		Matcher m = SPECIAL_SEPARATOR_PATTERN.matcher(str);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return str.split(SEPARATOR);
	}

	private static boolean isPositive(String str) {
		return Pattern.matches(POSITIVE_PATTERN, str);
	}

	private static boolean isBlankOrNull(String str) {
		return (str == null || str.isEmpty());
	}

}
