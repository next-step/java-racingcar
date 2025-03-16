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
        ResultView.printTitle();

        for (int i = 0; i < tryCount; i++) {
            ResultView.printTryCount(i + 1);
            race();
            ResultView.printCars(this);
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
