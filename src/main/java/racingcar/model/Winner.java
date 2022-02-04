package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> carList;

    public Winner(List<Car> car) {
        this.carList = new ArrayList<>(car);
    }

    public ArrayList<String> winnerList() {
        int maxPosition = maximumDistance();
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int maximumDistance() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = car.checkMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
