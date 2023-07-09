package car.domain;

import car.domain.model.Car;
import car.domain.model.Cars;
import car.domain.model.Count;
import car.view.OutputView;
import java.util.Collections;
import java.util.List;

public final class RacingService {

    private final Cars cars;
    private final Count count;

    public RacingService(final String inputCarNames, final int inputCount) {
        OutputView.printResultText();
        cars = new Cars(inputCarNames);
        count = new Count(inputCount);
    }

    public boolean isRacing() {
        return count.isRacingRemain();
    }

    public void runRaceOnce() {
        count.decreaseTryCount();
        cars.raceOnce();
    }

    public Cars getEachRaceResult() {
        return cars;
    }

    public List<Car> selectWinner() {
        return Collections.unmodifiableList(cars.getWinnerCars());
    }

}
