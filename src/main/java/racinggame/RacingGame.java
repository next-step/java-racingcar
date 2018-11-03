package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racinggame.domain.Car;

public class RacingGame {

	private List<Car> cars;
	private int time;

	public RacingGame(int carNumber, int time) {
		readyCar(carNumber);
		this.time = time;
	}

	private void readyCar(int carNumber) {
		cars = Stream.generate(Car::new)
				.limit(carNumber)
				.collect(Collectors.toList());
	}

	public List<Car> move() {
		changeTime();
		for(Car car : cars) {
			int randomPosition = RandomGenerator.getInstance().getRandomPosition();
			car.move(randomPosition);
		}
		return cars;
	}

	private void changeTime() {
		time--;
	}

	public boolean isOver() {
		final int LAST_GAME = 0;
		return time == LAST_GAME;
	}
}
