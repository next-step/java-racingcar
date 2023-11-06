package study.carracing;

import java.util.ArrayList;
import java.util.List;
import study.carracing.domain.Car;
import study.carracing.domain.RacingCars;

public class Racing {

    private final RacingCars racingCars;

    public Racing(int carCount) {
        this.racingCars = addRacingCars(carCount);
    }

    private RacingCars addRacingCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return new RacingCars(cars);
    }

    public void start(int tryCount) {
        racingCars.move(tryCount);
    }

    public RacingCars getCars() {
        return racingCars;
    }
}
