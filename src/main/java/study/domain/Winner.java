package study.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinner() {
        return findWinner(getWinnerPosition());
    }

    private List<Car> findWinner(int winnerPosition) {
        List<Car> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.matchPosition(winnerPosition)) {
                winnerList.add(car);
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
