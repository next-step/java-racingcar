package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final int difficulty;

    public RacingGame(final int difficulty) {
        this.difficulty = difficulty;
    }

    public List<RacingCar> makeRacingCars(final int numberOfCars) {
        return IntStream.rangeClosed(1, numberOfCars)
                .mapToObj(RacingCar::new)
                .collect(Collectors.toList())
                ;
    }

    public void race(final List<RacingCar> racingCars) {
        racingCars.stream()
                .forEach(this::moveIfCan)
        ;
    }

    private void moveIfCan(final RacingCar racingCar) {
        if (canMove()) {
            racingCar.move();
        }
    }

    private boolean canMove() {
        return RandomUtils.nextInt(0, 9) >= difficulty;
    }
}
