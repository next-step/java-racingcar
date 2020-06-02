package step4;

import step4.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private int maxPosition;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinnerNames() {
        calcMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void calcMaxPosition() {
        maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> {
            if (moveStrategy.move())
                car.move();
        });
    }
}
