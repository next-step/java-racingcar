package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

	private static final int CUSTOM_DELIMITER_INDEX = 1;
	private static final int NUMBERS_INDEX = 2;

	public int additionCalculate(final String input) {
		if (input == null || input.equals("")) {
			return 0;
		}

		Matcher matcher = getMatcher(input);

		if (matcher.find()) {
			return calculateAdditionWithCustomSign(matcher);
		}

		return calculateAddition(input.split(",|:"));
	}

	private static Matcher getMatcher(String input) {
		return patternCompile().matcher(input);
	}

	private static Pattern patternCompile() {
		return Pattern.compile(CUSTOM_SEPARATOR);
	}

	private static int calculateAdditionWithCustomSign(final Matcher matcher) {
		String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
		String[] numbers = matcher.group(NUMBERS_INDEX).split(customDelimiter);

		return calculateAddition(numbers);
	}

	private static int calculateAddition(final String[] number) {
		int result = 0;

		for (int i = 0; i < number.length; i++) {
			checkNegativeNumber(number, i);
			result += Integer.parseInt(number[i]);
		}
		return result;
	}

	private static void checkNegativeNumber(final String[] number, final int i) {
		if (Integer.parseInt(number[i]) < 0) {
			throw new RuntimeException("음수는 입력할 수 없습니다. 0 이상의 숫자를 입력해주세요.");
		}
	}
}
