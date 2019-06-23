package com.java.jaeheon.step2.domain;

public class Car {
    private static final int INITIAL_VALUE = 0;
    private static final int MOVING_CONDITION = 4;

    private final int numberOfAttempts;
    private final int position;
    private final String nameOfCar;

    public Car(String nameOfCar) {
        this.numberOfAttempts = INITIAL_VALUE;
        this.position = INITIAL_VALUE;
        this.nameOfCar = nameOfCar;
    }

    public Car(int position, String nameOfCar) {
        this(INITIAL_VALUE, position, nameOfCar);
    }

    public Car(int numberOfAttempts, int position, String nameOfCar) {
        this.numberOfAttempts = numberOfAttempts;
        this.position = position;
        this.nameOfCar = nameOfCar;
    }

    public Car attemptsToMove(int condition) {
        return MOVING_CONDITION <= condition ? go() : stop();
    }

    private Car go() {
        return new Car(getNumberOfAttempts() + 1, getPosition() + 1, getNameOfCar());
    }

    private Car stop() {
        return new Car(getNumberOfAttempts() + 1, getPosition(), getNameOfCar());
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public Integer getPosition() {
        return position;
    }

    public int getMaxPosition(int maxPosition) {
        return this.position > maxPosition ? this.position : maxPosition;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    public String getNameOfCar() {
        return nameOfCar;
    }

}