package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.ui.UIInGame;
import racingcar.util.RandomNumberGenerator;

public final class RacingGame {
	public static void runRound(final List<Car> cars, final Integer roundCount) {
		for (int round = 1; round <= roundCount; round++) {
			race(cars);
			UIInGame.printPosition(round, cars);
		}
	}

	private static void race(final List<Car> cars) {
		for (int carNum = 0; carNum < cars.size(); carNum++) {
			cars.get(carNum).move(RandomNumberGenerator.randomNumber());
		}
	}

}
