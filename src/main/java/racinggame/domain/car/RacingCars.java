package racinggame.domain.car;

import racinggame.domain.move.MoveBehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {
    private static final int CAR_INIT_POSITION = 0;
    private final List<RacingCar> racingCars;

    public RacingCars(final int carCount) {
        this.racingCars = new ArrayList<>();
        IntStream.range(0, carCount)
                .forEach(index -> racingCars.add(new RacingCar(CAR_INIT_POSITION)));
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars move(MoveBehavior moveBehavior) {
        List<RacingCar> moveRacingCars = racingCars.stream()
                .map(car -> car.move(moveBehavior.isMove()))
                .collect(Collectors.toList());
        return new RacingCars(moveRacingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
