package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {
	private static final String CUSTOM_SEPERATOR_REGEX = "//(.*)\\n(.*)";
	private static final String DEFAULT_SEPERATOR = ",|:";
	private static final Pattern CUSTOM_SEPERATOR_PATTERN = Pattern.compile(CUSTOM_SEPERATOR_REGEX);
	private static final int CUSTOM_SEPERATOR_GROUP_INDEX = 1;
	private static final int INT_LIST_GROUP_INDEX = 2;

	public static int calculate(String text) {
		if (isEmptyVal(text)) {
			return 0;
		}

		Matcher matcher = CUSTOM_SEPERATOR_PATTERN.matcher(text);
		String result = text;
		String separator = DEFAULT_SEPERATOR;

		if (matcher.find()) {
			separator = DEFAULT_SEPERATOR + "|" + matcher.group(CUSTOM_SEPERATOR_GROUP_INDEX);
			result = matcher.group(INT_LIST_GROUP_INDEX);
		}

		return parseAndSum(result.split(separator));
	}

	private static boolean isEmptyVal(String text) {
		return text == null || text.isEmpty();
	}

	private static int parseAndSum(String[] stringArray) {
		int sumResult = 0;
		for (String s : stringArray) {
			sumResult += parseInt(s);
		}
		return sumResult;
	}

	private static int parseInt(String string) {
		int number = Integer.parseInt(string);
		if (number < 0) {
			throw new RuntimeException();
		}
		return number;
	}
}
