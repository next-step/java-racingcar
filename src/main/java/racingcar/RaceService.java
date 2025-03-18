package racingcar;

public class RaceService {
	private final Race race;
	private final Cars cars;

	public RaceService(String carInput, int roundInput) {
		this.race = new Race(roundInput);
		this.cars = new Cars(carInput);
	}

	public void runRace() {
		OutputView.printResultMessage();
		while (race.hasRemainRound()) {
			runOneRound();
		}
	}

	private void runOneRound() {
		cars.moveCars(randomMovingStrategy());
		race.reduceRound();
		cars.getCarsLocation()
			.forEach(OutputView::printCarDistance);
		OutputView.printEndOneRound();
	}

	private MovingStrategy randomMovingStrategy() {
		return new RandomMovingStrategy();
	}

}
