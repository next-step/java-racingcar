package racinggame;

import java.util.List;
import java.util.Random;
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
			car.move(getRandomPosition());
		}
		return cars;
	}

	private void changeTime() {
		time--;
	}

	private int getRandomPosition() {
		final int MAX_MOVE_POSITION = 10;
		Random random = new Random();
		return random.nextInt(MAX_MOVE_POSITION);
	}

	public boolean isOver() {
		final int LAST_GAME = 0;
		return time == LAST_GAME;
	}
}
