package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> nameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : nameList) {
            cars.add(new RacingCar(name));
        }
        return new Cars(cars);
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max().orElseThrow(IllegalStateException::new);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        StringBuilder carsState = new StringBuilder();
        for (Car car : cars) {
            carsState.append(car);
            carsState.append("\n");
        }
        carsState.append("------------------------------\n");
        return carsState.toString();
    }
}
