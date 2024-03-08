package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public List<String> dashOfCarPositions() {
        return cars.stream()
                .map(Car::carPosition)
                .collect(Collectors.toList());
    }

    public void playRound(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.play(moveStrategy);
        }
    }

}
