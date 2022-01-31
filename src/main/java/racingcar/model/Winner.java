package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> car) {
        this.cars = new ArrayList<>(car);
    }

    public List<String> findWinner() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.findPositionWithMax(maxPosition)) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.compareMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
