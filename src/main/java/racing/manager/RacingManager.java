package racing.manager;

import java.util.ArrayList;
import java.util.List;
import racing.model.Car;

public class RacingManager {

    private final List<Car> cars;

    public RacingManager(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> checkWinner() {
        List<Car> winners = new ArrayList<>();

        int maxPos = -1;
        for (Car car : cars) {
            maxPos = Math.max(maxPos, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPos) {
                winners.add(car);
            }
        }

        return winners;
    }

}
