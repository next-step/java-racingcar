package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> car) {
        this.cars = car;
    }

    public List<String> getWinner() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getCarName());
            }
        }
        return winnerList;
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
