package step_3;

import java.util.List;

public class RaceCourse {

    private final ResultView resultView = new ResultView();

    private final List<Car> cars;
    private final int roundCount;

    public RaceCourse(List<Car> cars, int roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public void startRace() {
        for (int i = 0; i < roundCount; i++) {
            moveCar();
            resultView.saveRaceResult(cars);
        }
    }

    private void moveCar() {
        cars.forEach(Car::move);
    }

    public void viewRaceResult() {
        resultView.viewResult();
    }
}

