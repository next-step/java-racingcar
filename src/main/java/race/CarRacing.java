package race;

import race.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();
    private int raceAttemptCount;

    public CarRacing(final int carsCount, final int raceAttemptCount) {
        for (int i = 0; i < carsCount; i ++) {
            cars.add(new Car());
        }

        this.raceAttemptCount = raceAttemptCount;
    }

    public void start() {
        for (Car car : cars) {
            car.go(raceAttemptCount);
        }
    }

    public void print() {
        for (int currentStep = 1; currentStep < raceAttemptCount + 1; currentStep++) {
            carPrint(currentStep);
            ResultView.println();
        }
    }

    private void carPrint(final int currentStep) {
        for (Car car : cars) {
            car.print(currentStep);
        }
    }
}
