package car_racing;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Car> cars;

    public Track(Integer carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void run() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
