package domain;

import java.util.Arrays;

public class UserInput {

    private final String[] namesForCars;
    private final int attemptCount;

    public UserInput(String inputNames, int attemptCount) {
        isOverOne(attemptCount);
        this.namesForCars = inputNames.split(",");
        this.attemptCount = attemptCount;
    }

    static void isOverOne(int... userInputs) {
        if (Arrays.stream(userInputs)
                .anyMatch(input -> input <= 0)) {
            notOverOne();
        }
    }


    private static void notOverOne() {
        throw new IllegalArgumentException("0 이상의 정수만 입력 가능합니다.");
    }

    public int getNumbersOfCar() {
        return namesForCars.length;
    }

    public String[] getNamesForCars() {
        return namesForCars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
