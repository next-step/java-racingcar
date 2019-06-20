package com.java.jaeheon.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.jaeheon.step2.controller.CarRaceController;

public class CarRacingTest {
	CarManagement carManagement;
	CarRaceController carRaceController;

	String namerOfCars;
	int numberOfAttempts;

	@BeforeEach
	void setup() {
		namerOfCars = "pobi,crong,honux";
		numberOfAttempts = 5;
		carManagement = carRaceController.carRegister(namerOfCars);
		CarRacing carRacing = new CarRacing(carManagement, numberOfAttempts);
//		carManagement = carRacing.carRacingStart();
	}

	@Test
	void numberOfRacingAttemptsByCar() {
		for (Car car : carManagement.getCarsList()) {
			assertThat(car.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
		}
	}

}
