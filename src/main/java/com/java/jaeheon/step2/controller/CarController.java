package com.java.jaeheon.step2.controller;

import java.util.ArrayList;
import java.util.List;

import com.java.jaeheon.step2.model.Car;
import com.java.jaeheon.step2.model.CarManagement;

public class CarController {

	public static CarManagement carRegister(int numberOfCars) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car());
		}
		return new CarManagement(cars);
	}

}
