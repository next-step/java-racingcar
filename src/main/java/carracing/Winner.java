package carracing;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winners = new ArrayList<>();

    public Winner(List<Car> cars) {
        this(cars, getMaxPosition(cars));
    }

    public Winner(List<Car> cars,int maxPosition) {
        for (Car car : cars) {
            getWinner(car, maxPosition);
        }
    }

    private void getWinner(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = max(car, maxPosition);
        }
        return maxPosition;
    }

    private static int max(Car car, int compareNumber) {
        if (car.getPosition() > compareNumber) {
            return car.getPosition();
        }
        return compareNumber;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
