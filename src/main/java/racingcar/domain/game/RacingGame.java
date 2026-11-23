package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.generator.NumberGenerator;

public class RacingGame {

	private Cars cars;
	private int round;

	public RacingGame(Cars cars, int round) {
		this.cars = cars;
		this.round = round;
	}

	public RacingGame(String carNames, int round) {
		this(new Cars(carNames), round);
	}

	public void play(NumberGenerator numberGenerator) {
		cars.play(numberGenerator);
		round--;
	}

	public boolean isFinished() {
		return round <= 0;
	}

	public List<Car> getCars() {
		return cars.getCars();
	}

	public List<String> findWinners() {
		return cars.findWinners();
	}

}
