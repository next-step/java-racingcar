package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racinggame.domain.Car;

public class RacingGame {

	private List<Car> cars;
	private int time;
	private RandomGenerator randomGenerator;

	public RacingGame(int carNumber, int time) {
		readyCar(carNumber);
		this.time = time;
		this.randomGenerator = new RandomGenerator();
	}

	private void readyCar(int carNumber) {
		cars = Stream.generate(Car::new)
				.limit(carNumber)
				.collect(Collectors.toList());
	}

	public List<Car> move() {
		changeTime();
		for(Car car : cars) {
			int randomNumber = randomGenerator.getRandomPosition();
			car.move(randomNumber);
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
