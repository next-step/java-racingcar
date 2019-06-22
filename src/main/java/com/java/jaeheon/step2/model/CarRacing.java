package com.java.jaeheon.step2.model;

import com.java.jaeheon.step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
	private static final int CONDITION_LIMIT = 10;
	private final Random random = new Random();

	private final int numberOfAttempts;
	private CarManagement carManagement;
	private RecordBoard recordBoard;

	public CarRacing(String nameOfCars, int numberOfAttempts) {
		this.carManagement = carRegister(nameOfCars);
		this.numberOfAttempts = numberOfAttempts;
		this.recordBoard = new RecordBoard();
	}

	private CarManagement carRegister(String nameOfCars) {
		String[] nameOfCarsArray = nameOfCars.split(",");
		List<Car> cars = new ArrayList<>();
		for (String nameOfCar : nameOfCarsArray) {
			cars.add(new Car(nameOfCar));
		}
		return new CarManagement(cars);
	}

	public void carRacingStart() {
		for (int attempts = 1; attempts <= numberOfAttempts; attempts++) {
			carManagement = race();
			recordBoard.racingRecorder(attempts, carManagement.getCars());
		}
	}

	private CarManagement race() {
		List<Car> cars = new ArrayList<>();
		for (Car car : carManagement.getCars()) {
			cars.add(car.attemptsToMove(createCondition()));
		}
		return new CarManagement(cars);
	}

	private int createCondition() {
		return random.nextInt(CONDITION_LIMIT);
	}

	public void resultViewer() {
		ResultView.resultViewRacing(recordBoard);
	}

}
