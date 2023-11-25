package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {

    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        return getWinnerByPosition(getWinnerPosition());
    }

    private List<String> getWinnerByPosition(int winnerPosition) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            winnerList.add(getWinnerCarName(winnerPosition, car));
        }
        winnerList.removeIf(Objects::isNull);
        return winnerList;
    }

    private String getWinnerCarName(int winnerPosition, Car car) {
        return (winnerPosition == car.getPosition()) ? car.getCarName() : null;
    }

    private int getWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = compareAndUpdateMaxPosition(maxPosition, car);
        }
        return maxPosition;
    }

    private int compareAndUpdateMaxPosition(int maxPosition, Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
