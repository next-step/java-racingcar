package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.racing.constant.Message;

public class Cars {
	private final List<Car> cars;

	private Cars(List<String> carNames) {
		this.cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(Car.create(carName));
		}
	}

	public static Cars of(List<String> carNames) {

		return new Cars(carNames);
	}

	public List<String> getWinners() {
		int maxValue = findMaxDistance();
		return this.cars.stream()
			.filter(car -> maxValue == car.getDistance())
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public GameResult moveCars() {
		for (Car car : this.cars) {
			car.move(GameRandom.isGameWin());
		}
		return GameResult.of(this.cars);
	}

	private int findMaxDistance() {
		return this.cars
			.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElseThrow(() -> new NullPointerException(Message.MSG_NOT_FOUND_DISTANCE));
	}
}
