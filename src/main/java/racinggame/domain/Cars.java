package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public RacingResult startRacing(int racingCount) {
        RacingResult racingResult = new RacingResult();
        for (int step = 0; step < racingCount; step++) {
            racingCar();
            racingResult.saveStepOfRacing(step, racingResult());
        }
        return racingResult;
    }

    private void racingCar() {
        cars.forEach(Car::moving);
    }

    private List<Car> racingResult() {
        return cars.stream()
                .map(car -> new Car(car.getCarName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
