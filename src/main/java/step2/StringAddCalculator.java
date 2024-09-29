package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int calculate(String text) {
		String CUSTOM_DELIMITER = "//(.*)\\n(.*)";
		String DEFAULT_DELIMITER = ",|:";

		if (text == null || text.isEmpty()) {
			return 0;
		}

		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
		if (matcher.find()) {
			String customSeperator = matcher.group(1);
			String numberArrayText = matcher.group(2);
			return splitByDelimiterAndSum(numberArrayText, DEFAULT_DELIMITER + "|" + customSeperator);
		}
		return splitByDelimiterAndSum(text, DEFAULT_DELIMITER);
	}

	private static int splitByDelimiterAndSum(String text, String DELIMITER) {
		return parseStringToInt(text.split(DELIMITER));
	}

	private static int parseStringToInt(String[] StringArray) {
		int sumResult = 0;
		for (String s : StringArray) {
			sumResult += Integer.parseInt(s);
		}
		return sumResult;
	}
}
