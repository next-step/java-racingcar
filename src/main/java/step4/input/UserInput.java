package step4.input;

import java.util.Arrays;

public class UserInput {
    private final String[] carNames;
    private final int tryNumber;

    public UserInput(final String[] carNames, final int tryNumber) {
        this.carNames = carNames;
        this.tryNumber = tryNumber;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "carNames=" + Arrays.toString(carNames) +
                ", tryNumber=" + tryNumber +
                '}';
    }
}
