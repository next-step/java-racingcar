package race;

import race.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();

    public CarRacing(final int carsCount) {
        for (int i = 0; i < carsCount; i ++) {
            cars.add(new Car());
        }
    }

    public void start(final int raceAttemptCount) {
        for (int i = 0; i < raceAttemptCount; i++) {
            carsStart();
        }
    }

    private void carsStart() {
        for (Car car : cars) {
            car.go();
        }

        ResultView.println();
    }
}
