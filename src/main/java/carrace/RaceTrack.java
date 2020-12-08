package carrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceTrack {
    private final List<Car> carList = new ArrayList<>();

    public RaceTrack(Car... cars) {
        carList.addAll(Arrays.asList(cars));
    }

    public void next() {
        for (Car car : carList) {
            car.tryMovingForward();
        }
    }

}
