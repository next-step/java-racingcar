package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

	public static final int LAST_TIME = 0;

	private List<Car> cars;
	private int time;
	private RandomGenerator randomGenerator;

	public RacingGame(String carNames, int time) {
		readyCar(carNames);
		this.time = time;
		this.randomGenerator = new RandomGenerator();
	}

	private void readyCar(String carNames) {
		cars = Arrays.stream(carNames.split("(\\s+)?,(\\s+)?"))
				.map(carName -> new Car(carName))
				.collect(Collectors.toList());
	}

	public List<Car> move() {
		changeTime();
		for(Car car : cars) {
			int randomNumber = randomGenerator.getRandomNumber();
			car.move(randomNumber);
		}
		return cars;
	}

	private void changeTime() {
		time--;
	}

	public boolean isOver() {
		return time == LAST_TIME;
	}

	public RacingGameResult getRacingGameResult() {
		return new RacingGameResult(cars);
	}
}
