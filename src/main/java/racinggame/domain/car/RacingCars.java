package racinggame.domain.car;

import racinggame.domain.move.MoveBehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int CAR_INIT_POSITION = 0;
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(final List<CarName> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        carNames.forEach(carName -> racingCars.add(new RacingCar(carName, CAR_INIT_POSITION)));
        return new RacingCars(racingCars);
    }

    public RacingCars move(final MoveBehavior moveBehavior) {
        List<RacingCar> moveRacingCars = racingCars.stream()
                .map(car -> car.move(moveBehavior.isMove()))
                .collect(Collectors.toList());
        return new RacingCars(moveRacingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
