package step5;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinner() {

        List<Car> winnerCarList = new ArrayList<>();
        for (Car car : cars) {
            if (getMaxPositionValue() <= car.getPosition()) {
                winnerCarList.add(car);
            }
        }

        return winnerCarList;
    }

    private int getMaxPositionValue() {
        int maxPositionValue = 0;
        for (Car car : cars) {
            if (maxPositionValue < car.getPosition()) {
                maxPositionValue = car.getPosition();
            }
        }
        return maxPositionValue;
    }


}
