package com.next.step.step3.dto;

import java.util.List;

public class InputDto {

    private final List<String> carNames;

    private final int numOfAttempts;

    public InputDto(List<String> carNames, int numOfAttempts) {
        this.carNames = carNames;
        this.numOfAttempts = numOfAttempts;
    }

    public int numOfCars() {
        return this.carNames.size();
    }

    public int numOfAttempts() {
        return numOfAttempts;
    }
}
