package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.racing.constant.Message;

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
		for (String carName : inputResult.getCarNames()) {
			cars.add(Car.createCar(carName));
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

	public List<String> getWinners() {
		if (this.gameResults.size() == 0)
			throw new IllegalStateException(Message.MSG_REQUEST_SIMULATOR_RUN);
		int maxValue = findMaxDistance();
		return this.partCars.stream()
			.filter(car -> maxValue == car.getDistanceLength())
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int findMaxDistance() {
		return this.partCars
			.stream()
			.mapToInt(Car::getDistanceLength)
			.max()
			.orElseThrow(() -> new NullPointerException(Message.MSG_NOT_FOUND_DISTANCE));
	}
}
