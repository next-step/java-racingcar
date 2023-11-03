package car_racing;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Car> cars;

    public Track(Integer carCount, Integer movingCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0, movingCount));
        }
    }
}
