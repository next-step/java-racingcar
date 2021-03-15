package step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(final String names) {
        for (String carName : names.split(",")) {
            cars.add(new Car(carName));
        }
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

    public List<Car> getCars() {
        return cars;
    }
}
