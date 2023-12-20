package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.ui.UIInGame;

public class RacingGame {
	public static void runRound(List<Car> cars, Integer roundCount) {
		for (int round = 1; round <= roundCount; round++) {
			race(cars);
			UIInGame.printPosition(round, cars);
		}
	}

	private static void race(List<Car> cars) {
		for (int carNum = 0; carNum < cars.size(); carNum++) {
			cars.get(carNum).move();
		}
	}

}
