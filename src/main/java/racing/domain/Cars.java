package racing.domain;

import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;



    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();
        List<String> winners = cars.stream()
                .filter(car -> car.samePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(",", winners);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
