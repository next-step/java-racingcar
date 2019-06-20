package com.java.jaeheon.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.jaeheon.step2.controller.CarController;

public class CarRacingTest {
	CarManagement carManagement;

	int numberOfCars;
	int numberOfAttempts;

	@BeforeEach
	void setup() {
		numberOfCars = 3;
		numberOfAttempts = 5;
		carManagement = CarController.carRegister(numberOfCars);
		CarRacing carRacing = new CarRacing(carManagement, numberOfAttempts);
		carManagement = carRacing.carRacingStart();
	}

	@Test
	void numberOfRacingAttemptsByCar() {
		for (Car car : carManagement.getCarsList()) {
			assertThat(car.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
		}
	}

}
