package racing;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
	private final List<Car> carList;
	private final int turn;
	private final RacingNotifier racingNotifier;

	public RacingGame(int carNum, int turn, RacingNotifier racingNotifier) {
		this.carList = IntStream.range(0, carNum).mapToObj(value -> createDefaultCar()).collect(Collectors.toList());
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	private static Car createDefaultCar() {
		return new Car(value -> value >= 4, () -> new Random().nextInt(10));
	}

	public RacingStatus start() {
		for (int i = 0; i < turn; i++) {
			carList.forEach(Car::getMoveForwardChance);
			racingNotifier.notifyRace(new RacingStatus(this.carList));
		}

		return new RacingStatus(this.carList);
	}
}
