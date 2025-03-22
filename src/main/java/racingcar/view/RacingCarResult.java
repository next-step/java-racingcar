package racingcar.view;

import java.util.List;

import racingcar.domain.RacingCar;

import static java.util.stream.Collectors.toList;

public class RacingCarResult {
    private static final String MOVE_SYMBOL = "-";

    private final String carName;
    private final int distance;

    public RacingCarResult(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
         return carName + " : " + MOVE_SYMBOL.repeat(distance);
    }

    public static List<RacingCarResult> of(List<RacingCar> racingCars) {
        return racingCars.stream()
            .map(RacingCar::toResult)
            .collect(toList());
    }
}
