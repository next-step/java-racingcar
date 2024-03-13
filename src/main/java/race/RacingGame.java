package race;

import race.domain.Cars;
import race.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Integer> points = new ArrayList<>();
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void start(int numberOfAttempts) {
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            saveMileages(cars);
            OutputView.printMileages(points);
            OutputView.printResultStatement();
        }
    }

    private void saveMileages(Cars cars) {
        points = cars.goForward();
    }

}
