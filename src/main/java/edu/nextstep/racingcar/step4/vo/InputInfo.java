package edu.nextstep.racingcar.step4.vo;

public class InputInfo {

    private final String namesOfCars;
    private final int numberOfAttempts;

    public InputInfo(String namesOfCars, int numberOfAttempts) {
        this.namesOfCars = namesOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getNamesOfCars() {
        return namesOfCars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
