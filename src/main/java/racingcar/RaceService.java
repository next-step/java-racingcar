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
		OutputView.printWinners(cars.getWinners());
	}

	private void runOneRound() {
		cars.moveCars(randomMovingStrategy());
		race.reduceRound();
		cars.getCarsNameAndLocation()
			.forEach(carInfo -> OutputView.printCarDistance(carInfo.name(), carInfo.location()));
		OutputView.printEndOneRound();
	}

	private MovingStrategy randomMovingStrategy() {
		return new RandomMovingStrategy();
	}

}
