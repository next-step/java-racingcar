package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.platform.commons.util.StringUtils;

public class Calculator {
	public static int calculate(String text) {
		if (StringUtils.isBlank(text)) {
			return 0;
		}
		String[] values = splitValues(text);
		return sum(values);
	}

	private static String[] splitValues(String text) {
		String[] values;

		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (matcher.find()){
			String customDelimiter = matcher.group(1);
			values  = matcher.group(2).split(customDelimiter);
		} else {
			values = text.split(",|:");
		}
		return values;
	}

	private static int sum(String[] values) {
		int result = 0;
		for (String value : values) {
			int num = Integer.parseInt(value);
			if (num < 0) {
				throw new RuntimeException();
			}
			result += num;
		}
		return result;
	}

}
