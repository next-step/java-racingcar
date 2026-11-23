package racingcar.domain.game;

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

	public RacingResult play(NumberGenerator numberGenerator) {
		cars.play(numberGenerator);
		round--;
		return new RacingResult(cars.getCars());
	}

	public boolean isFinished() {
		return round <= 0;
	}

}
