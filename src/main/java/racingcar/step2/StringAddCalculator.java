package racingcar.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String SEPARATOR = "[,:]";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

	private StringAddCalculator() {
	}

	public static int calculate(String input) {
		if (isBlank(input)) {
			return 0;
		}

		Matcher matcher = PATTERN.matcher(input);
		if (matcher.find()) {
			return sum(toPositives(split(matcher.group(2), matcher.group(1))));
		}

		return sum(toPositives(split(input)));
	}

	private static boolean isBlank(String input) {
		return input == null || input.isBlank();
	}

	private static String[] split(String input) {
		return input.split(SEPARATOR);
	}

	private static String[] split(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static List<Positive> toPositives(String[] values) {
		List<Positive> positives = new ArrayList<>();
		for (String value : values) {
			positives.add(toPositive(value));
		}

		return positives;
	}

	private static Positive toPositive(String value) {
		return new Positive(value);
	}

	private static int sum(List<Positive> positives) {
		Positive result = new Positive(0);
		for (Positive positive : positives) {
			result = result.plus(positive);
		}

		return result.number();
	}
}
