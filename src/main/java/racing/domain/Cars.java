package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public Cars (Cars cars) {
        this(cars.cars);
    }

    public Cars(List<Car> carList) {
        cars = carList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getList() {
        return cars;
    }

    public void playRound(Movable movable) {
        for (Car car : cars) {
            car.moveByCondition(movable.isMovable());
        }
    }

    public List<String> getWinnersName() {
        int maxPosition = maxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int maxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }

}
