package racingcar;

import java.util.ArrayList;
import java.util.List;

public class DicideWinner {
    private List<Car> carList;

    public DicideWinner(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> getWinner() {
        int max = getMaxDistance();
        List<String> winner = new ArrayList<>();
        for (Car car : carList) {
            if (max == car.getLocation()) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

    public int getMaxDistance() {
        int max = 0;
        for (Car car : carList) {
            if (max < car.getLocation()) {
                max = car.getLocation();
            }
        }
        return max;
    }

}
