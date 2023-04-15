package com.next.step.step3.dto;

import java.util.List;

public class InputDto {

    private final String carNames;

    private final int numOfAttempts;

    public InputDto(String carNames, int numOfAttempts) {
        this.carNames = carNames;
        this.numOfAttempts = numOfAttempts;
    }

    public int numOfAttempts() {
        return numOfAttempts;
    }

    public String carNames() {
        return carNames;
    }
}
