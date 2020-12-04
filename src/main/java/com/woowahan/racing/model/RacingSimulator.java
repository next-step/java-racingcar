package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;

import com.woowahan.racing.util.GameRandom;

public class RacingSimulator {

	private final InputResult inputResult;
	private final List<Car> partCars;
	private final List<GameResult> gameResults;

	private RacingSimulator(InputResult inputResult) {
		this.inputResult = inputResult;
		this.partCars = participateCars();
		this.gameResults = new ArrayList<>();
	}

	public static RacingSimulator createSimulator(InputResult inputResult) {
		return new RacingSimulator(inputResult);
	}

	private List<Car> participateCars() {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < inputResult.getCarCount(); i++) {
			cars.add(Car.createCar());
		}
		return cars;
	}

	public List<GameResult> run() {
		for (int i = 0; i < inputResult.getTryCount(); i++) {
			gameResults.add(moveCars());
		}
		return this.gameResults;
	}

	private GameResult moveCars() {
		for (Car car : this.partCars) {
			car.move(GameRandom.isGameWin());
		}
		return GameResult.of(this.partCars);
	}

}
