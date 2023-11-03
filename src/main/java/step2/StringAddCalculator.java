package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private final static int ZERO = 0;
	private final static Pattern CUSTOM_MATCHER = Pattern.compile("//(.)\n(.*)");
	private final static String COMMA_OR_COLON = ",|:";
	private final static int DELIMITER_INDEX = 1;
	private final static int MATCHED_RESULT_INDEX = 2;

	public String[] stringNumbers(String input) {
		if(input == null || input.isEmpty()) {
			return new String[]{};
		}

		Matcher m = CUSTOM_MATCHER.matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(DELIMITER_INDEX);
			return m.group(MATCHED_RESULT_INDEX).split(customDelimiter);
		}

		return input.split(COMMA_OR_COLON);
	}

	public int sum(String[] numbers) {
		if (numbers.length == ZERO) {
			return ZERO;
		}

		if (hasNegativeNumbers(numbers)) {
			throw new RuntimeException("주어진 숫자에 음수가 있습니다");
		}

		Number x = new Sum(numbers);
		return x.intValue();
	}

	private boolean hasNegativeNumbers(String[] numbers) {
		Boolean b = new HasLessThan(numbers, ZERO);

		return b.booleanValue();
	}
}
