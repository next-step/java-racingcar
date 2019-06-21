package com.java.jaeheon.step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
	private static final int CONDITION_LIMIT = 10;
	private final Random random = new Random();

	private final int numberOfAttempts;
	private CarManagement carManagement;
	private RecordBoard recordBoard;

	public CarRacing(CarManagement carManagement, int numberOfAttempts) {
		this.carManagement = carManagement;
		this.numberOfAttempts = numberOfAttempts;
		this.recordBoard = new RecordBoard();
	}

	public RecordBoard carRacingStart() {
		for (int attempts = 1; attempts <= numberOfAttempts; attempts++) {
			carManagement = race();
			recordBoard.racingRecorder(attempts, carManagement.getCarsList());
		}
		return recordBoard;
	}

	private CarManagement race() {
		List<Car> cars = new ArrayList<>();
		for (Car car : carManagement.getCarsList()) {
			cars.add(car.attemptsToMove(createCondition()));
		}
		return new CarManagement(cars);
	}

	private int createCondition() {
		return random.nextInt(CONDITION_LIMIT);
	}

}
