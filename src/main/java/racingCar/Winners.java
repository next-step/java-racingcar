package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> value() {
        return this.cars;
    }

    public static Winners getWinners(List<Car> carList) {
        return getWinners(carList, getMaxDistance(carList));
    }

    private static Winners getWinners(List<Car> carList, Distance maxDistance) {
        List<Car> winners = new ArrayList<>();

        for(Car car : carList) {
            if(car.isMax(maxDistance)) {
                winners.add(car);
            }
        }
        return new Winners(winners);
    }

    private static Distance getMaxDistance(List<Car> carList) {
        Distance max = new Distance();
        for(Car car : carList) {
            max = car.max(max);
        }
        return max;
    }
}
