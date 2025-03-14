package racingcar;

public class RaceService {
	private final Race race;
	private final Cars cars;

	public RaceService(int carInput, int roundInput) {
		this.race = new Race(roundInput);
		this.cars = new Cars(carInput);
	}

	public void runRace() {
		OutputView.printResultMessage();
		while (race.getRemainingRounds() > 0) {
			runOneRound();
		}
	}

	private void runOneRound() {
		cars.moveCars();
		race.reduceRound();
		OutputView.printEndOneRound();
	}

}
