package carracing.model;

import static carracing.RacingGameSetupValidator.isPositiveInteger;

public class NumberOfAttempts {
    private static final String WRONG_NUMBER_OF_ATTEMPTS_MESSAGE = "시도 횟수는 양의 정수만 가능합니다.";

    private final int numberOfAttempts;

    public NumberOfAttempts(String numberOfAttempts) {
        if(!isPositiveInteger(numberOfAttempts)) {
           throw new IllegalArgumentException(WRONG_NUMBER_OF_ATTEMPTS_MESSAGE);
        }
        this.numberOfAttempts = Integer.parseInt(numberOfAttempts);
    }

    public int numberOfAttempts() {
        return numberOfAttempts;
    }

    public boolean isSame(int num) {
        return numberOfAttempts == num;
    }
}
