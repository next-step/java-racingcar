package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static String DEFAULT_DELIMITER = ",|:";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	private static final List<String> RESTRICTED_DELIMITERS = List.of("|", "\\");
	private static Pattern compile = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
	public static Integer calculate(String text) {
		if (isBlank(text)) {
			return 0;
		}

		String[] splitText = split(text);
		validate(splitText);
		return sum(splitText);
	}

	private static boolean isBlank(String text) {
		return text == null || text.isBlank();
	}

	private static String[] split(String text) {
		Matcher matcher = compile.matcher(text);
		if (matcher.find()) {
			return matcher.group(2).split(getDelimiter(matcher.group(1)));
		} else if (text.startsWith("//")) {
			return text.substring(4).split(getDelimiter(Character.toString(text.charAt(2))));
		}
		return text.split(DEFAULT_DELIMITER);
	}

	private static int sum(String[] values) {
		return Arrays.stream(values)
			.mapToInt(value -> Integer.parseInt(value))
			.sum();
	}

	private static String getDelimiter(String delimiter) {
		return RESTRICTED_DELIMITERS.contains(delimiter) ? String.format("\\%s", delimiter) : delimiter;
	}

	private static void validate(String[] values) {
		Optional<String> negative = Arrays.stream(values)
			.filter(s -> Integer.parseInt(s) < 0)
			.findFirst();

		if (negative.isPresent()) {
			throw new RuntimeException();
		}
	}
}
