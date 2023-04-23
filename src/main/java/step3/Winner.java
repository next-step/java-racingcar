package step3;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> winners = new ArrayList<>();
    private int max;

    public int getMax() {
        return max;
    }

    public void addWinner(List<Car> cars) {
        for (Car car : cars) {
            setMaxGoCount(car);
        }

    }

    private void setMaxGoCount(Car car) {
        if (max < car.getGoCount()) {
            max = car.getGoCount();
        }
    }

}
