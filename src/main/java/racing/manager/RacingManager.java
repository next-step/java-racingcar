package racing.manager;

import java.util.List;
import java.util.stream.Collectors;
import racing.model.Car;

public class RacingManager {

    private final List<Car> cars;

    public RacingManager(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> checkWinner() {
        int maxPosition = getMaxPosition();
        return this.cars.stream()
                        .filter(cur -> cur.getPosition() == maxPosition)
                        .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

}
