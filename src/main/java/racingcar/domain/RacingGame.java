package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final int difficulty;
    private RacingCars racingCars;

    public RacingGame(final int difficulty, final String[] names) {
        this.difficulty = difficulty;
        this.racingCars = makeRacingCars(names);
    }

    public RacingCars race() {
        changeRacingCars(this.racingCars.race(getMovingStrategy()));
        return getRacingCars();
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public void changeRacingCars(final RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars whoIsTheWinner() {
        return this.racingCars.
                whoWentTheFarthest()
                ;
    }

    private RacingCars makeRacingCars(final String[] names) {
        return new RacingCars(
                IntStream.rangeClosed(1, names.length)
                        .mapToObj(i -> new RacingCar(names[i - 1], 0))
                        .collect(Collectors.toList())
        );
    }

    private MovingStrategy getMovingStrategy() {
        return () -> RandomUtils.nextInt(0, 9) >= difficulty;
    }
}
