package racingCar;

public class Racing {
	private static final char ASCII_ZERO = 48;
	private static final char ASCII_NINE = 57;

	public static void playRace() {
		Print.participantsOfRacing();
		String participant = InputView.input();
		Print.howManyMatches();
		String matches = InputView.input();

		Print.execute();

		result(participant, checkInput(matches));
	}

	private static void result(String participant, String matches) {
		playMatches(participate(participant), matches);
	}

	private static void playMatches(Cars cars, String matches) {
		for (int i = 0; i < Integer.parseInt(matches); i++) {
			playMatch(cars, i);
		}
	}

	private static void playMatch(Cars cars, int index) {
		cars.move();
		Views.results(cars, index);
	}

	public static Cars participate(String input) {
		return new Cars(input.split(","));
	}

	public static String checkInput(String input) {
		if (validateMinus(input) || validateCharacterNotNumber(input)) {
			throw new RuntimeException();
		}
		return input;
	}

	private static boolean validateMinus(String input) {
		return Integer.parseInt(input) < 0;
	}

	private static boolean validateCharacterNotNumber(String input) {
		return ASCII_NINE < input.charAt(0) && input.charAt(0) < ASCII_ZERO;
	}
}
