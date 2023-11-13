package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private final static String DEFAULT_DELIMITER_REGEX = ",|:";
	private final static Pattern ADD_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String str) {
		if (isEmpty(str)) {
			return 0;
		}

		return Arrays.stream(
				findTargetAndDelimiter(str).getNumbers()
			)
			.mapToInt(StringAddCalculator::parseInt)
			.sum();
	}

	private static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private static Splitter findTargetAndDelimiter(String str) {
		Matcher m = ADD_DELIMITER_PATTERN.matcher(str);
		if (m.find()) {
			String customDelimiter = DEFAULT_DELIMITER_REGEX + "|" + m.group(1);
			return Splitter.of(m.group(2), customDelimiter);
		}
		return Splitter.of(str, DEFAULT_DELIMITER_REGEX);
	}

	private static int parseInt(String number) {
		int parseInt = Integer.parseInt(number);
		if (isNegative(parseInt)) {
			throw new IllegalArgumentException(ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
		}
		return parseInt;
	}


	private static boolean isNegative(Integer number) {
		return number < 0;
	}
}