package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {

    private List<Car> cars = new ArrayList<>();
    public RacingCars(int carCount) {
        this.cars = createCars(carCount);
    }


    public int numberOfParticipants() {
        return cars.size();
    }


    public void moveCar(RandomStrategy strategy) {
        for (Car car : cars) {
            car.moveForward(strategy.create());
        }
    }


    private List<Car> createCars(int carCount) {
        return Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
