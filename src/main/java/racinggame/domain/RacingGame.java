package racinggame.domain;

import java.util.List;
import racinggame.dto.RacingGameInfo;
import racinggame.utils.RandomGenerator;

public class RacingGame {

	public static final int LAST_TIME = 0;

	private List<Car> cars;
	private int time;
	private RandomGenerator randomGenerator;

	public RacingGame(RacingGameInfo racingGameInfo) {
		this.cars = racingGameInfo.readyCar();
		this.time = racingGameInfo.getTime();
		this.randomGenerator = new RandomGenerator();
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
