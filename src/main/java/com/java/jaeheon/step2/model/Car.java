package com.java.jaeheon.step2.model;

public class Car {
	private final int MOVING_CONDITION = 4;
	private final int INITIAL_VALUE = 0;

	private final int numberOfAttempts;
	private final int position;
	private final String nameOfCar;

	public Car(String nameOfCar) {
		this.numberOfAttempts = INITIAL_VALUE;
		this.position = INITIAL_VALUE;
		this.nameOfCar = nameOfCar;
	}

	public Car(int numberOfAttempts, int position, String nameOfCar) {
		this.numberOfAttempts = numberOfAttempts;
		this.position = position;
		this.nameOfCar = nameOfCar;
	}

	public Car attemptsToMove(int condition) {
		if (MOVING_CONDITION <= condition) {
			return new Car(getNumberOfAttempts() + 1, getPosition() + 1, getNameOfCar());
		}
		return new Car(getNumberOfAttempts() + 1, getPosition(), getNameOfCar());
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public Integer getPosition() {
		return position;
	}

	public String getNameOfCar() {
		return nameOfCar;
	}

}
