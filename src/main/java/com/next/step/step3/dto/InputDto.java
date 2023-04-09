package com.next.step.step3.dto;

public class InputDto {

    private final int numOfCars;

    private final int numOfAttempts;

    public InputDto(int numOfCars, int numOfAttempts) {
        this.numOfCars = numOfCars;
        this.numOfAttempts = numOfAttempts;
    }

    public int numOfCars() {
        return numOfCars;
    }

    public int numOfAttempts() {
        return numOfAttempts;
    }
}
