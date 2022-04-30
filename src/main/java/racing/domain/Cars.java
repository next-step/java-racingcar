package racing.domain;

import racing.domain.exception.DuplicateNameException;
import racing.domain.strategy.NormalMove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        HashSet<Car> carSet = new HashSet<>(cars);
        if (carSet.size() < cars.size()) {
            throw new DuplicateNameException();
        }
    }

    public void moveCars() {
        cars.forEach(car -> car.move(new NormalMove(NumberGenerator.generate())));
    }

    public Cars getWinnerCars() {
        return new Cars(WinnerCars.findWinnerCars(cars));
    }

    public List<String> getCarNames() {
        List<String> cars = new ArrayList<>();
        for (Car car : this.cars) {
            cars.add(car.getName());
        }
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\r\n");
        }
        return sb.toString();
    }
}
