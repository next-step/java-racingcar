package carracing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int MAX_POSITION_INITIAL_VALUE = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void moveCars(Car car) {
        car.move(RandomNumber.createRandomNumber());
    }

    public List<String> makeWinners() {
        List<String> winners = new ArrayList<>();
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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
