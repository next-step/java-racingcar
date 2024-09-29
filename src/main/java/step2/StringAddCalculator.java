package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	static String CUSTOM_SEPERATOR_REGEX = "//(.*)\\n(.*)";
	static String DEFAULT_SEPERATOR = ",|:";

	public static int calculate(String text) {
		if (isEmptyVal(text)) {
			return 0;
		}
		String seperator = getSeperator(text);
		String result = getResultText(text);
		return parseAndSum(result.split(seperator));
	}

	private static String getResultText(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_SEPERATOR_REGEX).matcher(text);
		if (matcher.find()) {
			return matcher.group(2);
		}
		return text;
	}

	private static String getSeperator(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_SEPERATOR_REGEX).matcher(text);
		if (matcher.find()) {
			return DEFAULT_SEPERATOR + "|" + matcher.group(1);
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
		try {
			int number = Integer.parseInt(string);
			return checkPositive(number);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	private static int checkPositive(int number) {
		if (number > 0) {
			return number;
		} else {
			throw new RuntimeException();
		}
	}
}
