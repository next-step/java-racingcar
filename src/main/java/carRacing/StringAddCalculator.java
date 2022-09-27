package carRacing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


	private static final String DELIMITER_REGEX = "//(.)\n(.*)";
	private static final String DEFAULT_REGEX = ",|:";
	private static final Integer TARGET_DELIMITER = 1;
	private static final Integer TARGET_TOKENS = 2;
	private static Integer answer = 0;

	public static int splitAndSum(String input) {

		if (input == null || input.isEmpty()) {
			return 0;
		}

		Matcher m = matcher(input);

		if (m.find()) {
			return calculate(Tokens(m));
		}

		String[] tokens = input.split(DEFAULT_REGEX);
		return calculate(tokens);

	}

	private static Matcher matcher(String input) {
		return Pattern.compile(DELIMITER_REGEX).matcher(input);
	}

	private static String[] Tokens(Matcher m) {
		String customDelimiter = m.group(TARGET_DELIMITER);
		return m.group(TARGET_TOKENS).split(customDelimiter);
	}

	public static int calculate(String[] tokens) {

		for (String token : tokens) {
			answer += toInt(token);
		}

		return answer;

	}

	private static int toInt(String token) {

		int num = Integer.parseInt(token);

		if (num < 0) {
			throw new RuntimeException();
		}

		return num;
	}
}



