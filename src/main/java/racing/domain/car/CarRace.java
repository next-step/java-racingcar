package racing.domain.car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.domain.car.exception.NegativePositionException;
import racing.domain.generator.DefaultNumberGenerator;
import racing.domain.generator.NumberGenerator;

public class CarRace {

    private static int MOVE_THRESHOLD = 4;

    private final List<Car> cars;
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

    public List<Car> cars() {
        return new ArrayList<>(cars);
    }

    public CarRace move() {
        List<Car> carList = cars.stream()
            .map(car -> move(car, numberGenerator))
            .collect(Collectors.toList());
        return new CarRace(carList);
    }

    public List<Name> winner() {
        int position = maxPosition();
        return cars.stream()
            .filter(car -> car.position() == position)
            .map(Car::name)
            .collect(Collectors.toList());
    }

    private int maxPosition() {
        return this.cars.stream()
            .max(Comparator.comparing(Car::position))
            .orElseThrow(() -> new NegativePositionException("전진한 자동차가 없습니다."))
            .position();
    }

    private Car move(Car car, NumberGenerator numberGenerator) {
        if (numberGenerator.randomNumber() < MOVE_THRESHOLD) {
            return car;
        }
        return car.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarRace carRace = (CarRace) o;
        return Objects.equals(cars, carRace.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
