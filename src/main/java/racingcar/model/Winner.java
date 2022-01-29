package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> car) {
        this.cars = car;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();

            }
        }
        return maxPosition;
    }
}
