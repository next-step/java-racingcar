package car_racing;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    @VisibleForTesting
    public void setCars(List<Car> carMocks) {
        cars = carMocks;
    }

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).moveOrStop();
        }
    }

    public List<Car> getWinner() {
        List<Integer> carMoveCounts = getCarMoveCounts();
        int maxIndex = Collections.max(carMoveCounts);
        return getWinCars(maxIndex);
    }

    private List<Integer> getCarMoveCounts() {
        List<Integer> carMoveCounts = new ArrayList<>();
        for (Car car : cars)
            carMoveCounts.add(car.getMoveCount());
        return carMoveCounts;
    }

    private List<Car> getWinCars(int maxIndex) {
        List<Car> winCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == maxIndex) {
                winCars.add(car);
            }
        }
        return winCars;
    }

}
