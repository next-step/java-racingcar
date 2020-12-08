package racing;

import racing.car.Car;
import racing.car.MoveForwardStrategy;
import racing.car.RandomMoveForwardStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private final List<Car> carList;
	private final int turn;
	private final RacingNotifier racingNotifier;

	public RacingGame(int carNum, int turn, RacingNotifier racingNotifier) {
		this.carList = createCarList(carNum);
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	private List<Car> createCarList(int carNum) {
		MoveForwardStrategy strategy = new RandomMoveForwardStrategy();
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carNum; i++) {
			Car car = new Car(strategy);
			carList.add(car);
		}
		return carList;
	}

	public RacingStatus start() {
		for (int i = 0; i < turn; i++) {
			carList.forEach(Car::getMoveForwardChance);
			racingNotifier.notifyRace(new RacingStatus(this.carList));
		}

		return new RacingStatus(this.carList);
	}
}
