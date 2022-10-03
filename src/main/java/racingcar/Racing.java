package racingcar;

public class Racing {
	private static ConditionStrategy conditionStrategy = new MatchCondition();

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
		for (int i = 0; i < cars.getCars().size(); i++) {
			int random = cars.getCars().get(i).makeRandom();
			cars.getCars().get(i).movingOfRound(random);
		}
		Views.results(cars, index);
	}

	public static Cars participate(String input) {
		return new Cars(input.split(","));
	}

	public static String checkInput(String input) {
		conditionStrategy.validInput(input);
		return input;
	}
}
