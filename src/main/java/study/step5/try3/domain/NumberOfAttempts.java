package study.step5.try3.domain;

public class NumberOfAttempts {
    private final int numberOfAttempts;

    private NumberOfAttempts(String userInputNumberOfAttempts) {
        this.numberOfAttempts = Integer.parseInt(userInputNumberOfAttempts);
    }

    public static NumberOfAttempts of(String userInputNumberOfAttempts) {
        if (isInvalid(userInputNumberOfAttempts)) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
        }
        return new NumberOfAttempts(userInputNumberOfAttempts);
    }

    private static boolean isInvalid(String userInputNumberOfAttempts) {
        if (!userInputNumberOfAttempts.matches("^([1-9]\\d*)$")) {
            return true;
        }
        return false;
    }

    public int getNumber() {
        return numberOfAttempts;
    }
}
