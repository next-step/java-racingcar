package domain;

import domain.strategy.RandomMovingStrategy;

public class RacingAttempt {

    private int attempt;

    private RacingAttempt(final String attempt) {

        this.attempt = convert(attempt);
    }

    public static RacingAttempt from(final String attempt) {

        return new RacingAttempt(attempt);
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
            throw new IllegalArgumentException("입력값은 1 이상이어야 합니다.");
        }
    }

    public boolean isAttempt() {

        return this.attempt > 0;
    }

    public void nextPlay(final RacingCars racingCars) {

        nextAttempt();
        racingCars.roundPlay(new RandomMovingStrategy());
    }

    public void nextAttempt() {

        this.attempt--;
    }
}
