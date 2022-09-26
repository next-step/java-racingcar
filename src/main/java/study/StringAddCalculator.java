package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String DEFAULT_DELIMITER = ",|:";

	public int splitAndSum(final String text) {
		if(checkNullOrEmpty(text)){
			return 0;
		}

		if(checkCustomDelimiter(text)){
			String[] tokens = split(findCustomDelimiter(text), trimCustomDelimiter(text));
			return sum(tokens);
		}

		return sum(split(text, DEFAULT_DELIMITER));
	}

	private boolean checkNullOrEmpty(final String text) {
		return text == null || text.isEmpty();
	}

	private boolean checkCustomDelimiter(final String text) {
		return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
	}

	private String findCustomDelimiter(final String text) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if(matcher.find()){
			return matcher.group(1);
		}
		return "";
	}

	private String trimCustomDelimiter(final String text) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if(matcher.find()){
			return matcher.group(2);
		}
		return "";
	}

	private String[] split(final String text, final String delimiters) {
		return text.split(delimiters);
	}

	private int sum(final String[] tokens) {
		int result = 0;
		for (String token : tokens) {
			if(!checkConvertToInt(token) || !checkPositiveNumber(token)){
				throw new RuntimeException();
			}
			result += Integer.parseInt(token);
		}
		return result;
	}

	private boolean checkConvertToInt(final String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean checkPositiveNumber(final String token) {
		return Integer.parseInt(token) > 0;
	}
}
