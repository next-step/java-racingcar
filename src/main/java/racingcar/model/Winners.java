package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<Car> cars;

    public Winners(List<Car> car) {
        this.cars = new ArrayList<>(car);
    }

    public ArrayList<String> winnerList() {
        int maxPosition = maximumDistance();
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition((maxPosition))) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int maximumDistance() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.checkMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
