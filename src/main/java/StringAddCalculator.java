import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private final static String DEFAULT_DELIMITER_REGEX = ",|:";
	private final static Pattern ADD_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String str) {
		if (hasNoValue(str)) {
			return 0;
		}

		return Arrays.stream(
				findTargetAndDelimiter(str).getNumbers()
			)
			.mapToInt(StringAddCalculator::parseInt)
			.sum();
	}

	private static boolean hasNoValue(String str) {
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
		try {
			return Integer.parseUnsignedInt(number);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// temp class name
	private static class Splitter {
		private final String target;
		private final String delimiter;

		public Splitter(String target, String delimiter) {
			this.target = target;
			this.delimiter = delimiter;
		}

		public static Splitter of(String target, String delimiter) {
			return new Splitter(target, delimiter);
		}

		private String[] getNumbers() {
			return target.split(delimiter);
		}
	}
}
