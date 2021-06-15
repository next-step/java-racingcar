package carracing.model;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private static final int MAX_POSITION_INITIAL_VALUE = 0;
    private List<Car> cars;
    private List<String> winners;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> makeWinners() {
        winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(calculateWinnerPosition())) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int calculateWinnerPosition() {
        int maxPosition = MAX_POSITION_INITIAL_VALUE;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
