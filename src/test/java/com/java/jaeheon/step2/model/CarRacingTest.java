package com.java.jaeheon.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.jaeheon.step2.controller.CarController;

public class CarRacingTest {
	CarManagement carManagement;

	String namerOfCars;
	int numberOfAttempts;

	@BeforeEach
	void setup() {
		namerOfCars = "pobi,crong,honux";
		numberOfAttempts = 5;
		carManagement = CarController.carRegister(namerOfCars);
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
