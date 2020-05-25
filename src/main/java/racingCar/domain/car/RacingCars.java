package racingCar.domain.car;

import racingCar.domain.moveStrategy.MoveBehavior;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCarList;

    public RacingCars(final String[] carNames) {
        this.racingCarList = initRacingCars(carNames);
    }

    public RacingCars(final List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    private List<RacingCar> initRacingCars(String[] carNames) {
        return Arrays.stream(carNames).map(RacingCar::new).collect(Collectors.toList());
    }

    public List<RacingCar> move(MoveBehavior moveBehavior) {
        racingCarList.forEach(racingCar -> racingCar.move(moveBehavior.isMove()));
        return Collections.unmodifiableList(racingCarList);
    }

    public List<RacingCar> getRacingCarList() {
        return Collections.unmodifiableList(racingCarList);
    }
}
