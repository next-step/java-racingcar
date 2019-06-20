package com.java.jaeheon.step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.java.jaeheon.step2.view.ResultView;

public class CarRacing {
	private static final int CONDITION_LIMIT = 10;

	private final int numberOfAttempts;
	private final Random random;
	private CarManagement carManagement;

	public CarRacing(CarManagement carManagement, int numberOfAttempts) {
		this.carManagement = carManagement;
		this.numberOfAttempts = numberOfAttempts;
		this.random = new Random();
	}

	public CarManagement carRacingStart() {
		for (int i = 0; i < numberOfAttempts; i++) {
			carManagement = race();
			ResultView.toTheNextLine();
		}
		return carManagement;
	}

	private CarManagement race() {
		List<Car> cars = new ArrayList<>();
		for (Car car : carManagement.getCarsList()) {
			cars.add(car.attemptsToMove(createCondition()));
			ResultView.resultViewDistanceByCar(car);
		}
		return new CarManagement(cars);
	}

	private int createCondition() {
		return random.nextInt(CONDITION_LIMIT);
	}
}
