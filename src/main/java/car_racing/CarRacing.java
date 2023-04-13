package car_racing;

import com.google.common.annotations.VisibleForTesting;

import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    @VisibleForTesting
    public void setCars(List<Car> carMocks) {
        cars = carMocks;
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).moveOrStop();
        }
    }

}
