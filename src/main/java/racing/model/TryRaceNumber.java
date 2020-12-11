package racing.model;

public class TryRaceNumber {

	private int tryRaceNumber;

	public TryRaceNumber(String userInputString) {

		if (!isNumber(userInputString)) {
			throw new IllegalArgumentException("숫자만 입력해 주세요.");
		}

		this.tryRaceNumber = Integer.parseInt(userInputString);
	}

	public static boolean isNumber(String inputNumber) {

		try {
			Integer.parseInt(inputNumber);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	public boolean isTryGame() {

		return (this.tryRaceNumber--) != 0;
	}
}
