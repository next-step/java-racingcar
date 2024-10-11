package carracing.domain.carracing;

import carracing.domain.carracing.dto.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(String[] carNames) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<String> winnersNames() {
        int maxPosition = -1;
        maxPosition = this.compareMax(maxPosition);

        return this.winnersNames(maxPosition);
    }

    private int compareMax(int maxPosition) {
        for (Car car : this.cars) {
            maxPosition = car.compareMax(maxPosition);
        }
        return maxPosition;
    }

    private List<String> winnersNames(int maxPosition) {
        return this.getCarsSamePositionAs(maxPosition)
                .stream()
                .map(Car::getNameString)
                .collect(Collectors.toList());
    }

    private List<Car> getCarsSamePositionAs(int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    public Cars deepCopy() {
        List<Car> copiedCars = new ArrayList<>();
        for (Car car : this.cars) {
            copiedCars.add(car.deepCopy());
        }
        return new Cars(copiedCars);
    }

    public List<Car> get() {
        return this.cars;
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : this.cars) {
            moveStrategy.move(car);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
