package racing.domain;

public class RacingAttempt {

    private int attempt;

    private RacingAttempt(final int attempt) {

        validateZero(attempt);
        this.attempt = attempt;
    }

    public static RacingAttempt from(final String attempt) {

        return new RacingAttempt(convert(attempt));
    }

    private static int convert(final String attempt) {

        try {
            return Integer.parseInt(attempt);
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
