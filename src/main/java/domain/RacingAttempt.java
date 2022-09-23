package domain;

public class RacingAttempt {

    private Number attempt;

    private RacingAttempt(final String attempt) {

        this.attempt = Number.from(attempt);
    }

    public static RacingAttempt from(final String attempt) {

        return new RacingAttempt(attempt);
    }

    public void nextPlay(final RacingCars racingCars) {

        this.attempt.nextAttempt();
        racingCars.roundPlay();
    }

    public boolean isAttempt() {

        return this.attempt.isAttempt();
    }
}
