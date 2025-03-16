package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void race() {
        for (Car car : cars) {
            car.race();
        }
    }

    public void race(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            race();
        }
    }

    public List<String> getPositionStrings() {
        List<String> positionStrings = new ArrayList<>();
        for (Car car : cars) {
            positionStrings.add(car.getPositionString());
        }
        return positionStrings;
    }
}
