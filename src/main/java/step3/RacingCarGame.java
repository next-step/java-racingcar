package step3;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGame {
    private RacingCars racingCars;
    private final Attempt attempt;

    RacingCarGame(RacingCars racingCars, final Attempt attempt) {
        this.racingCars = racingCars;
        this.attempt = attempt;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public RacingCarGame play() {
        return new RacingCarGame(racingCars.move(), attempt.make());
    }

    //public List<RacingCar> findWinner() {
        /*Optional<Integer> topDistance = racingCarList.stream()
                .map(RacingCar::getDistance)
                .reduce(Integer::max);

        return racingCarList.stream()
                .filter(r -> topDistance.get() == r.getDistance())
                .collect(Collectors.toList());*/
    //}

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarGame that = (RacingCarGame) o;
        return racingCars.equals(that.racingCars) && attempt.equals(that.attempt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars, attempt);
    }
}
