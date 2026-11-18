package racingcar.game;

import racingcar.car.Cars;
import racingcar.generator.NumberGenerator;

public class RacingGame {

	private Cars cars;
	private int round;

	public RacingGame(Cars cars, int round) {
		this.cars = cars;
		this.round = round;
	}

	public void play(NumberGenerator numberGenerator) {
		cars.play(numberGenerator);
		round--;
	}

	public boolean isFinished() {
		return round <= 0;
	}
}
