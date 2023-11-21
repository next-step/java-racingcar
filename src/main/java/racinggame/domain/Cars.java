package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        List<String> winnerList = new ArrayList<>();
        int winnerPosition = getWinnerPosition();
        for (Car car : cars) {
            if (winnerPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int getWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = compareAndUpdateMaxPosition(maxPosition, car);
        }
        return maxPosition;
    }

    private static int compareAndUpdateMaxPosition(int maxPosition, Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
