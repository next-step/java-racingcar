package com.woowahan.racing.model;

import java.util.List;

public class GameResult {

	private final List<Car> carList;

	private GameResult(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> getCarList() {
		return carList;
	}
}
