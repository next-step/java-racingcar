package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public static RacingCars createRacingCars(final int playerCount) {
        return IntStream.range(0, playerCount)
                .mapToObj(RacingCar::init)
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
