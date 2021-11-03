package racingcar.util;

public final class NumberUtils {
	private NumberUtils() {
	}

	public static boolean isPositiveNumber(int number) {
		return number > 0;
	}

	public static boolean isNotPositiveNumber(int number) {
		return !isPositiveNumber(number);
	}
}
