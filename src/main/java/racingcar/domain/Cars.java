package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> carList) {
        this.cars = carList;
    }

    public static Cars createWithNames(List<String> names) {
        List<Car> carList = names.stream().map(Car::createWithName)
                .collect(Collectors.toList());
        return createFromList(carList);
    }

    public static Cars createFromList(List<Car> carList) {
        return new Cars(carList);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> movedCars = cars
                .stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());
        return new Cars(movedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cars)) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(getCars(), cars1.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCars());
    }
}
