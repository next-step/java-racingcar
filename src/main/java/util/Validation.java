package util;

public class Validation {
	public static boolean isValidCarList(String racingcarListString) {
		String[] racingcarList = racingcarListString.split(",");
		boolean returnValue = true;
		for (String racingcar : racingcarList) {
			returnValue = returnValue && isValidCarElement(racingcar);
		}

		if (!returnValue) {
			InputView.getErrorMessage();
		}
		return returnValue;
	}

	public static boolean isValidCarElement(String racingcar) {
		return racingcar.length() <= 5 && racingcar.length() > 0;
	}

	public static boolean isValidRepeatTime(String repeatTime) {
		return !repeatTime.startsWith("0") && repeatTime.matches("^[0-9]+$");
	}
}
