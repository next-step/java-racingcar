package car_racing;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    @VisibleForTesting
    public void setCars(List<Car> carMocks) {
        cars = carMocks;
    }

    public void initCars(int carSize) {
        for (int i = 0; i < carSize; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).moveOrStop();
        }
    }

}
