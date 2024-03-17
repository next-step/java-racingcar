package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class Calculator {
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String DELIMITER = ",|:";

	public static int calculate(String text) {
		if (StringUtils.isBlank(text)) {
			return 0;
		}
		String[] values = splitValues(text);
		return sum(values);
	}

	private static String[] splitValues(String text) {
		String[] values;

		Matcher matcher = PATTERN.matcher(text);
		if (matcher.find()){
			String customDelimiter = matcher.group(1);
			values  = matcher.group(2).split(customDelimiter);
		} else {
			values = text.split(DELIMITER);
		}
		return values;
	}

	private static int sum(String[] values) {
		int result = 0;
		for (String value : values) {
			int num = parseNonNegativeInteger(value);
			result += num;
		}
		return result;
	}

	private static int parseNonNegativeInteger(String value) {
		int num = Integer.parseInt(value);
		if (num < 0) {
			throw new RuntimeException();
		}
		return num;
	}

}
