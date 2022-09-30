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

		Views.winOfRacing(result(participant, checkInput(matches)));
	}

	private static Cars result(String participant, String matches) {
		return playMatches(participate(participant), matches);
	}

	private static Cars playMatches(Cars cars, String matches) {
		for (int i = 0; i < Integer.parseInt(matches); i++) {
			playMatch(cars, i);
		}
		return cars;
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
