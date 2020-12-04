package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

	private final List<Car> cars;

	private GameResult(List<Car> cars) {
		this.cars = cars;
	}

	public static GameResult of(List<Car> cars) {
		List<Car> newCars = new ArrayList<>();
		for (Car car : cars) {
			newCars.add(car.clone());
		}
		return new GameResult(newCars);
	}

	public List<Car> getCars() {
		return cars;
	}

}
