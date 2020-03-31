package racingcar.car;

import racingcar.RacingGameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private List<Car> cars;

    public CarCollection(int numberOfCars, Class engineClass) {
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(createCar(engineClass));
        }
    }

    private Car createCar(Class<Engine> engineClass) {
        try {
            return new Car(engineClass.getDeclaredConstructor().newInstance());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public RacingGameResult getResult() {
        List<Car> result = cars.stream()
                .map(car -> new Car(car.getRecord()))
                .collect(Collectors.toList());
        return new RacingGameResult(result);
    }
}
