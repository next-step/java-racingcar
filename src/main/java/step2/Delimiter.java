package step2;

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
}
