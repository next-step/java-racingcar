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

	public void run() {
		for (int i = 0; i < inputResult.getTryCount(); i++) {
			gameResultList.add(racingCars());
		}
	}

	public GameResult racingCars() {
		for (Car car : this.partCarList) {
			car.move(GameRandom.isGameWin());
		}
		return GameResult.of(this.partCarList);
	}

	public List<GameResult> getGameResultList() {
		return gameResultList;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("RacingSimulator{");
		sb.append("inputResult=").append(inputResult);
		sb.append(", partCarList=").append(partCarList);
		sb.append(", gameResultList=").append(gameResultList);
		sb.append('}');
		return sb.toString();
	}
}
