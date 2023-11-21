package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    public static final int BOUND = 10;
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars raceOnce(RandomService randomService) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move(randomService.nextInt(BOUND));
        }
        return this;
    }

    public List<String> findWinners() {
        long finishLine = findMaxPosition();
        return racingCars.stream()
                .filter(racingCar -> racingCar.isLocated(finishLine))
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }

    private long findMaxPosition() {
        return this.racingCars.stream()
                .reduce(0L,
                        (currentMax, racingCar) -> racingCar.updateMaxPosition(currentMax),
                        Long::max);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
