package calculator;

public class Delimiter {
	private static final String DEFAULT_DELIMITERS = ":,";
	private final String delimiter;

	private Delimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public String[] split(String input) {
		return input.split(delimiter);
	}

	public static Delimiter ofDefault() {
		return new Delimiter("[" + DEFAULT_DELIMITERS + "]");
	}

	public static Delimiter ofCustom(String input) {
		String customDelimiter = input.substring(input.indexOf("//") + 2, input.indexOf("\n"));
		return new Delimiter("[" + DEFAULT_DELIMITERS + customDelimiter + "]");
	}

	 public void validate(String input) {
		String regex = "[\\d" + getDelimiter() + "]+";
		if (!input.matches(regex)) {
			throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다.");
		}
	}
}
