package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	static final String Separator = ",|:";
	static final String pattern = "//(.)\n(.*)";
	static final String IntegerPattern = "^[0-9]*$";

	public static int splitAndSum(String str) {
		if (isBlankOrNull(str)) {
			return 0;
		}
		if (isInteger(str)) {
			return Integer.parseInt(str);
		}
		return getSum(split(str));
	}

	private static int getSum(String[] numbers) {
		int result = 0;
		int strToNumber;
		for (String str : numbers) {
			strToNumber = Integer.parseInt(str);
			result += strToNumber;
			if (!isInteger(str)) {
				throw new RuntimeException();
			}
		}
		return result;
	}

	private static String[] split(String str) {
		Matcher m = Pattern.compile(pattern).matcher(str);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return str.split(Separator);
	}

	private static boolean isInteger(String str) {
		return Pattern.matches(IntegerPattern, str);
	}

	private static boolean isBlankOrNull(String str) {
		return (str == null || str.isEmpty());
	}

}
