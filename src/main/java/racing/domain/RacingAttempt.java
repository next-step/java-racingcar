package racing.domain;

public class RacingAttempt {

    private int attempt;

    public RacingAttempt(final String attempt) {

        this.attempt = convert(attempt);
    }

    private int convert(final String attempt) {

        try {
            int number = Integer.parseInt(attempt);
            validateZero(number);
            return number;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void validateZero(final int attempt) {

        if (attempt == 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public boolean canAttempt() {

        return this.attempt > 0;
    }

    public void attempt() {

        this.attempt--;
    }
}
