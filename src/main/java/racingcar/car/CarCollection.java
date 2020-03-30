package racingcar.car;

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

    public CarCollection(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<List<Integer>> getResult() {
        return cars.stream()
                .map(Car::getRecord)
                .collect(Collectors.toList());
    }
}
