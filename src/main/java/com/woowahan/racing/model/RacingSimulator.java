package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;

import com.woowahan.racing.util.GameRandom;

public class RacingSimulator {

	private final InputResult inputResult;
	private final List<Car> partCarList;
	private final List<GameResult> gameResultList;

	private RacingSimulator(InputResult inputResult) {
		this.inputResult = inputResult;
		this.partCarList = participateCarList();
		this.gameResultList = new ArrayList<>();
	}

	public static RacingSimulator getInstance(InputResult inputResult) {
		return new RacingSimulator(inputResult);
	}

	private List<Car> participateCarList() {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < inputResult.getCarCount(); i++) {
			carList.add(Car.getInstance());
		}
		return carList;
	}

	public List<GameResult> run() {
		for (int i = 0; i < inputResult.getTryCount(); i++) {
			gameResultList.add(racingCars());
		}
		return this.gameResultList;
	}

	public GameResult racingCars() {
		for (Car car : this.partCarList) {
			car.move(GameRandom.isGameWin());
		}
		return GameResult.of(this.partCarList);
	}

}
