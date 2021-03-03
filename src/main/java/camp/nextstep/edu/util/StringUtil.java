package camp.nextstep.edu.util;

import java.util.Optional;

public class StringUtil {
	private static final String numericRegex = "^[0-9]+";

	public static String getStringIfNullBlank(String param) {
		return Optional.ofNullable(param)
			.orElse("");
	}

	public static boolean isNumeric(String word) {
		return word.matches(numericRegex);
	}
}
