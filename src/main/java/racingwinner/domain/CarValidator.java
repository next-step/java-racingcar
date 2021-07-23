package racingwinner.domain;

public class CarValidator {

	private static final int NAME_LENGTH_LIMIT = 5;

	public static boolean isValidName(String name) {
		return name.length() <= NAME_LENGTH_LIMIT;
	}
}
