package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;

public class CarRace {

    private static int MOVE_NUMBER = 4;
    private List<Car> cars;
    private final NumberGenerator numberGenerator;

    public CarRace(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public CarRace(List<Car> cars) {
        this.cars = cars;
        this.numberGenerator = new DefaultNumberGenerator();
    }

    public int size() {
        return cars.size();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> cars() {
        return new ArrayList<>(cars);
    }

    public void move() {
        this.cars = cars.stream()
            .map(car -> move(car, numberGenerator))
            .collect(Collectors.toList());
    }

    private Car move(Car car, NumberGenerator numberGenerator) {
        if (numberGenerator.randomNumber() < MOVE_NUMBER) {
            return car;
        }
        return car.move();
    }
}
