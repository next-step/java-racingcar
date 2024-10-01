package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {
	private static final String CUSTOM_SEPERATOR_REGEX = "//(.*)\\n(.*)";
	private static final String DEFAULT_SEPERATOR = ",|:";
	private static final Pattern CUSTOM_SEPERATOR_PATTERN = Pattern.compile(CUSTOM_SEPERATOR_REGEX);
	private static final int CUSTOM_SEPERATOR_GROUP = 1;
	private static final int INT_LIST_GROUP = 2;

	public static int calculate(String text) {
		if (isEmptyVal(text)) {
			return 0;
		}
		String seperator = getSeperator(text);
		String result = getResultText(text);
		return parseAndSum(result.split(seperator));
	}

	private static String getResultText(String text) {
		Matcher matcher = CUSTOM_SEPERATOR_PATTERN.matcher(text);
		if (matcher.find()) {
			return matcher.group(INT_LIST_GROUP);
		}
		return text;
	}

	private static String getSeperator(String text) {
		Matcher matcher = CUSTOM_SEPERATOR_PATTERN.matcher(text);
		if (matcher.find()) {
			return DEFAULT_SEPERATOR + "|" + matcher.group(CUSTOM_SEPERATOR_GROUP);
		}
		return DEFAULT_SEPERATOR;
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
