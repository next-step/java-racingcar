package com.java.jaeheon.step2.controller;

import java.util.ArrayList;
import java.util.List;

import com.java.jaeheon.step2.model.Car;
import com.java.jaeheon.step2.model.CarManagement;
import com.java.jaeheon.step2.model.CarRacing;
import com.java.jaeheon.step2.model.RecordBoard;
import com.java.jaeheon.step2.view.ResultView;

public class CarRaceController {
	private CarManagement carManagement;
	private CarRacing carRacing;
	private RecordBoard recordBoard;

	public CarManagement carRegister(String nameOfCars) {
		String[] nameOfCarsArray = nameOfCars.split(",");
		List<Car> cars = new ArrayList<>();
		for (String nameOfCar : nameOfCarsArray) {
			cars.add(new Car(nameOfCar));
		}
		carManagement = new CarManagement(cars);
		return carManagement;
	}

	public CarRacing carRacingReady(int numberOfAttempts) {
		carRacing = new CarRacing(carManagement, numberOfAttempts);
		return carRacing;
	}

	public void carRacingStart() {
		recordBoard = carRacing.carRacingStart();
	}

	public void resultViewer() {
		ResultView.resultViewRacing(recordBoard);
	}
}
