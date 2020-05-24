package racingCar.domain.car;

import racingCar.domain.car.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCarList;

    public RacingCars(final String[] carNames) {
        this.racingCarList = initRacingCars(carNames);
    }

    private List<RacingCar> initRacingCars(String[] carNames) {
        return Arrays.stream(carNames).map(RacingCar::new).collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
