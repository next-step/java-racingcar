package racingcar.util;

import racingcar.exception.UtilCreationException;

public final class NumberUtils {
	private NumberUtils() {
		throw new UtilCreationException();
	}

	public static boolean isPositiveNumber(int number) {
		return number > 0;
	}

	public static boolean isNotPositiveNumber(int number) {
		return !isPositiveNumber(number);
	}
}
