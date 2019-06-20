package com.java.jaeheon.step2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.java.jaeheon.step2.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
	Car car;

	int numberOfAttempts;
	int position;

	@BeforeEach
	void setup() {
		numberOfAttempts = 0;
		position = 0;
		this.car = new Car(numberOfAttempts, position);
	}

	@ParameterizedTest
	@ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
	void moveAfterAttempt(int condition) {
		assertThat(car.getPosition() + 1).isEqualTo(car.attemptsToMove(condition).getPosition());
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3 })
	void stopAfterAttempt(int condition) {
		assertThat(car.getPosition()).isEqualTo(car.attemptsToMove(condition).getPosition());
	}

}
