package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private static final int MAX_POSITION_INITIAL_VALUE = 0;
    private static final int RACING_COUNT_FIRST_INDEX = 0;
    private List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    private int calculateWinnerPosition() {
        int maxPosition = MAX_POSITION_INITIAL_VALUE;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> makeWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(calculateWinnerPosition())) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    public void moveCars(int racingCount) {
        for (int i = RACING_COUNT_FIRST_INDEX; i < racingCount; i++) {
            for (Car car : cars) {
                car.move(RandomNumber.createRandomNumber());
            }
        }
    }
}
