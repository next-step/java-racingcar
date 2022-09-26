package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String DEFAULT_DELIMITER = ",|:";

	public int splitAndSum(final String text) {
		// 빈 문자열 또는 null 값을 입력한 경우
		if(checkNullOrEmpty(text)){
			return 0;
		}

		// 커스텀 구분자로 나누는 경우
		if(checkCustomDelimiter(text)){
			return convertToIntAndSum(trimCustomDelimiter(text).split(findCustomDelimiter(text)));
		}

		// 기본 구분자로 나누는 경우(커스텀 구분자가 없는 경우)
		return convertToIntAndSum(text.split(DEFAULT_DELIMITER));
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

	private int convertToIntAndSum(final String[] tokens) {
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
