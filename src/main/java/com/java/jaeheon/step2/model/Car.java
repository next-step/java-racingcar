package com.java.jaeheon.step2.model;

public class Car {
	private final int MOVING_CONDITION = 4;
	private final int INITIAL_VALUE = 0;

	private final int numberOfAttempts;
	private final int position;

	public Car() {
		this.numberOfAttempts = INITIAL_VALUE;
		this.position = INITIAL_VALUE;
	}

	public Car(int numberOfAttempts, int position) {
		this.numberOfAttempts = numberOfAttempts;
		this.position = position;
	}

	public Car attemptsToMove(int condition) {
		if (MOVING_CONDITION <= condition) {
			return new Car(getNumberOfAttempts() + 1, getPosition() + 1);
		}
		return new Car(getNumberOfAttempts() + 1, getPosition());
	}

	public int getPosition() {
		return position;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}
}
