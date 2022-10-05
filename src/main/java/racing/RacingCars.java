package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<RacingCar> racingCars;

    private RacingCars(final int carCount) {
        racingCars = IntStream.range(0, carCount)
                .mapToObj(num -> RacingCar.init())
                .collect(Collectors.toList());
    }

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars init(final int carCount) {
        return new RacingCars(carCount);
    }

    public static RacingCars of(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
