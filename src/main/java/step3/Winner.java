package step3;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> winners = new ArrayList<>();
    private int max;

    public int getMax() {
        return max;
    }

    public List<Car> addWinner(List<Car> cars) {
        for (Car car : cars) {
            setMaxGoCount(car);
        }

        for (Car car : cars) {
            addOrNot(car);
        }
        return winners;
    }

    private void addOrNot(Car car) {
        if (car.getGoCount() == max) {
            winners.add(car);
        }
    }

    private void setMaxGoCount(Car car) {
        if (max < car.getGoCount()) {
            max = car.getGoCount();
        }
    }

}
