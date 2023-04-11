package domain;

import java.util.Arrays;

public class UserInput {

    private final int numbersOfCar;
    private final int attemptCount;

    public UserInput(int numbersOfCar, int attemptCount) {
        isOverOne(numbersOfCar, attemptCount);
        this.numbersOfCar = numbersOfCar;
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
        return numbersOfCar;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
