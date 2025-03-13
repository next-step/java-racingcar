package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final Pattern SPLIT_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");

	private StringAddCalculator() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static int splitAndSum(String text) {
		if (isNullOrBlank(text))
			return 0;

		String delimiter = DEFAULT_DELIMITER;
		Matcher m = SPLIT_DELIMITER_PATTERN.matcher(text);
		if (m.find()) {
			delimiter = m.group(1);
			text = m.group(2);
		}

		String[] tokens = split(delimiter, text);
		return sum(tokens);
	}

	private static boolean isNullOrBlank(String text) {
		return text == null || text.isBlank();
	}

	private static String[] split(String delimiter, String text) {
		return text.split(delimiter);
	}

	private static int sum(String[] tokens) {
		int result = 0;
		for (String token : tokens) {
			validateToken(token);
			result += Integer.parseInt(token);
		}
		return result;
	}

	private static void validateToken(String token) {
		if (!INTEGER_PATTERN.matcher(token)
			.matches()) {
			throw new RuntimeException("정수만 전달할 수 있습니다: " + token);
		}
		if (Integer.parseInt(token) < 0) {
			throw new RuntimeException("음수를 전달할 수 없습니다: " + token);
		}
	}
}
