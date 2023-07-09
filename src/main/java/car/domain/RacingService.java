package car.domain;

import car.domain.model.Car;
import car.domain.model.Cars;
import car.domain.model.Count;
import car.view.OutputView;
import java.util.Collections;
import java.util.List;

public final class RacingService {

    private static class RacingServiceHolder {

        private static final RacingService racingService = new RacingService();
    }

    private Cars cars;
    private Count count;


    private RacingService() {
        OutputView.printResultText();
    }

    public static RacingService getInstance() {
        return RacingServiceHolder.racingService;
    }

    public void setCarsAndCount(String inputCarNames, int inputCount) {
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
