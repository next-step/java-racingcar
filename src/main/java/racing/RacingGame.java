package racing;

public class RacingGame {
	private final int turn;
	private final RacingNotifier racingNotifier;

	public RacingGame(int carNum, int turn, RacingNotifier racingNotifier) {
		this.carList = IntStream.range(0, carNum).mapToObj(value -> createDefaultCar()).collect(Collectors.toList());
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	public RacingStatus start() {
		for (int i = 0; i < turn; i++) {
			carList.forEach(Car::getMoveForwardChance);
			racingNotifier.notifyRace(new RacingStatus(this.carList));
		}

		return new RacingStatus(this.carList);
	}
}
