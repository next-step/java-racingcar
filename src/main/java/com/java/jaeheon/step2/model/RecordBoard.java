package com.java.jaeheon.step2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecordBoard {
	private Map<Integer, List<Car>> recordByAttempts = new HashMap<>();

	public RecordBoard racingRecorder(int attempts, List<Car> cars) {
		recordByAttempts.put(attempts, cars);
		return this;
	}

	public Map<Integer, List<Car>> getRecord() {
		return recordByAttempts;
	}

	public String getWinner() {
		int maxPosition = 0;

		List<Car> cars = recordByAttempts.get(recordByAttempts.size());
		for (Car comparedCar : cars) {
			maxPosition = CompareRecords(maxPosition, comparedCar.getPosition());
		}

		final int max = maxPosition;
		List<String> winners = cars.stream().filter(car -> car.getPosition().equals(max)).map(car -> car.getNameOfCar()).collect(Collectors.toList());

		return winners.toString();
	}

	private int CompareRecords(int maxPosition, int comparedPosition) {
		if (maxPosition == 0) {
			return comparedPosition;
		}
		if (maxPosition > comparedPosition) {
			return maxPosition;
		}
		return comparedPosition;
	}

}
