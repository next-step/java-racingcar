package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DefaultSplitter {
	private static final String DEFAULT_SEPARATOR = ",|:";

	public String[] split(String input) {
		return input.split(DEFAULT_SEPARATOR);
	}
}
