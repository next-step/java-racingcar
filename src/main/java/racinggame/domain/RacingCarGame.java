package racinggame.domain;

import java.util.*;

public class RacingCarGame {
    private RacingCars racingCars;
    private final Attempt attempt;

    public RacingCarGame(RacingCars racingCars, final Attempt attempt) {
        this.racingCars = racingCars;
        this.attempt = attempt;
    }

    public RacingCarGame play() {
        return new RacingCarGame(racingCars.move(), attempt.make());
    }

    public boolean isEnd() {
        return attempt.isEnd();
    }

    public List<RacingCar> findWinner() {
        return racingCars.getWinner();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof RacingCarGame)) {
            return false;
        }

        RacingCarGame that = (RacingCarGame) o;
        return racingCars.equals(that.racingCars) && attempt.equals(that.attempt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars, attempt);
    }
}
