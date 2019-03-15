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
        racingCars.get()
                .stream()
                .forEach(this::moveIfCan)
        ;
        return getRacingCars();
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public RacingCars whoIsTheWinner() {
        final int farthestPosition = getFarthestPosition();
        return new RacingCars(
                this.racingCars
                        .get()
                        .stream()
                        .filter(racingCar -> racingCar.getPosition() == farthestPosition)
                        .collect(Collectors.toList())
        );
    }

    private RacingCars makeRacingCars(final String[] names) {
        return new RacingCars(
                IntStream.rangeClosed(1, names.length)
                        .mapToObj(id -> new RacingCar(id, names[id - 1]))
                        .collect(Collectors.toList())
        );
    }

    private void moveIfCan(final RacingCar racingCar) {
        racingCar.move(getMovingStrategy());
    }

    private MovingStrategy getMovingStrategy() {
        return () -> RandomUtils.nextInt(0, 9) >= difficulty;
    }

    private int getFarthestPosition() {
        return this.racingCars
                .get()
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0)
                ;
    }
}
