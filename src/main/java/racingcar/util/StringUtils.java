package racingcar.util;

import racingcar.exception.UtilCreationException;

public final class StringUtils {
	private StringUtils() {
		throw new UtilCreationException();
	}

	public static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
