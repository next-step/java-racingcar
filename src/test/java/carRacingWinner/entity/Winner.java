package carRacingWinner.entity;

import java.util.List;

public class Winner {


    public int location(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getLocation() > max)
                max = car.getLocation();
        }
        return max;
    }
}
