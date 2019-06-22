package com.java.jaeheon.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
	Car car;

	@BeforeEach
	void setup() {
		String nameOfCar = "testCar";
		this.car = new Car(nameOfCar);
	}

	@Test
	void go() {
		Car goCar = car.attemptsToMove(4);
		assertThat(goCar.getPosition()).isEqualTo(1);
	}

	@Test
	void stop() {
		Car stopCar = car.attemptsToMove(3);
		assertThat(stopCar.getPosition()).isEqualTo(0);
	}

	@Test
	void getMaxPosition() {
		Car stopCar = car.attemptsToMove(3);
		Car goCar = car.attemptsToMove(4);
		assertThat(stopCar.getMaxPosition(goCar.getPosition())).isEqualTo(1);
	}



}
