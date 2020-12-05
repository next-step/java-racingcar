package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingSimulator {

	private final InputResult inputResult;
	private final Cars partCars;
	private final List<GameResult> gameResults;

	private RacingSimulator(InputResult inputResult) {
		this.inputResult = inputResult;
		this.partCars = Cars.of(participateCars());
		this.gameResults = new ArrayList<>();
	}

	public static RacingSimulator createSimulator(InputResult inputResult) {
		return new RacingSimulator(inputResult);
	}

	private List<Car> participateCars() {
		List<Car> cars = new ArrayList<>();
		for (String carName : inputResult.getCarNames()) {
			cars.add(Car.createCar(carName));
		}
		return cars;
	}

	public List<GameResult> run() {
		for (int i = 0; i < inputResult.getTryCount(); i++) {
			gameResults.add(partCars.moveCars());
		}
		return this.gameResults;
	}

	public Cars getPartCars() {
		return partCars;
	}
}
