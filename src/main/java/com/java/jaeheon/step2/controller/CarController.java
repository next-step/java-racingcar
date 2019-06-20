package com.java.jaeheon.step2.controller;

import java.util.ArrayList;
import java.util.List;

import com.java.jaeheon.step2.model.Car;
import com.java.jaeheon.step2.model.CarManagement;

public class CarController {

	public static CarManagement carRegister(String nameOfCars) {
		String[] nameOfCarsArray = nameOfCars.split(",");
		List<Car> cars = new ArrayList<>();
		for (String nameOfCar : nameOfCarsArray) {
			cars.add(new Car(nameOfCar));
		}
		return new CarManagement(cars);
	}
}
