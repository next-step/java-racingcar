package racingcar;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingCarList {
    private final List<RacingCar> racingCars;

    public RacingCarList(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> currentRacingCars() {
        return racingCars;
    }

    public static RacingCarList initialize(int carCount) {
        List<RacingCar> racingCars = IntStream.range(0, carCount)
                .map(integer -> 0)
                .mapToObj(RacingCar::positionOf)
                .collect(toList());
        return new RacingCarList(racingCars);
    }

    public RacingCarList next() {
        List<RacingCar> nextRacingCars = racingCars.stream()
                .map(racingCar -> {
                    int randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
                    return RacingCar.positionOf(racingCar.nextPosition(randomNumber));
                }).collect(toList());
        return new RacingCarList(nextRacingCars);
    }
}
