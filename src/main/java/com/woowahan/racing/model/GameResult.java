package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

	private final List<Car> carList;

	private GameResult(List<Car> carList) {
		this.carList = carList;
	}

	public static GameResult of(List<Car> carList) {
		List<Car> newList = new ArrayList<>();
		for (Car car : carList) {
			newList.add(car.clone());
		}
		return new GameResult(newList);
	}

	public List<Car> getCarList() {
		return carList;
	}


}
