package domain;

import java.util.Arrays;

public class UserInput {

    private int carNumber;
    private int attemptCount;

    public UserInput(int carNumber, int attemptCount) {
        isOverOne(carNumber, attemptCount);
        this.carNumber = carNumber;
        this.attemptCount = attemptCount;
    }

    static void isOverOne(int... userInputs) {
        Arrays.stream(userInputs)
                .filter(input -> input <= 0)
                .forEach(UserInput::notOverOne);
    }

    private static void notOverOne(int input) {
        throw new IllegalArgumentException("0 이상의 정수만 입력 가능합니다.");
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
