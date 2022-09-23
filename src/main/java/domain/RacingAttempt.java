package domain;

public class RacingAttempt {

    private Number numberAttempt;

    private RacingAttempt(final String attempt) {

        this.numberAttempt = Number.from(attempt);
    }

    public static RacingAttempt from(final String count) {

        return new RacingAttempt(count);
    }

    public void race(final RacingCars racingCars) {

        this.numberAttempt.nextAttempt();
        racingCars.play();
    }

    public boolean isAttempt() {

        return this.numberAttempt.isAttempt();
    }
}
