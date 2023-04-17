package step2_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static final int ZERO = 0;
	private static final String DEFAULT_REGEX = ",|:";
	private static final String CUSTOM_REGEX_PATTERN = "//(.)\n(.*)";
	private static final String NEGATIVE_ERROR_MSG = "음수 값 발견";
	private static final String PARSEINT_ERROR_MSG = "NumberFormat 변환 중 오류 발생";
	private static final Pattern CUSTOM_COMPILED_PATTERN = Pattern.compile(CUSTOM_REGEX_PATTERN);

	private static StringAddCalculator stringAddCalculator;

	private StringAddCalculator() {
	}

	public static StringAddCalculator getInstance() {
		if (stringAddCalculator == null) {
			stringAddCalculator = new StringAddCalculator();
		}

		return stringAddCalculator;
	}

	public int splitAndSum(String text) {

		if (isBlank(text)) {
			return ZERO;
		}

		String regex = DEFAULT_REGEX;
		Matcher matcher = CUSTOM_COMPILED_PATTERN.matcher(text);

		if (matcher.find()) {
			regex += '|' + matcher.group(1);
			String customText = matcher.group(2);
			return sum(new Positive(split(customText, regex)));
		}

		return sum(new Positive(split(text, DEFAULT_REGEX)));
	}

	private boolean isBlank(String text) {
		return text == null || text.isBlank();
	}

	private String[] split(String text, String regex) {
		return text.split(regex);
	}


	private int sum(Positive positive) {
		int sum = ZERO;

		for (int number : positive.getNumbers()) {
			sum += number;
		}
		return sum;
	}
}
