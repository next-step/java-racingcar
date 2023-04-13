package domain;

import java.util.stream.IntStream;

public class UserInput {

    private final String[] namesForCars;
    private final int attemptCount;
    private final String[] INVALID_NAME_INPUTS = {"\t", "\n", ""};

    public UserInput(String inputNames, int attemptCount) {
        isNotEmptyNames(inputNames);
        isOverOne(attemptCount);
        this.namesForCars = inputNames.split(",");
        this.attemptCount = attemptCount;
    }

    private void isNotEmptyNames(String inputNames) {

        if (IntStream.range(0, INVALID_NAME_INPUTS.length)
                .anyMatch(i -> INVALID_NAME_INPUTS[i].equals(inputNames))) {
            throw new IllegalArgumentException("빈 값을 입력하시면 안됩니다.");
        }
    }

    static void isOverOne(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("0 보다 큰 정수만 입력 가능합니다.");
        }
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
