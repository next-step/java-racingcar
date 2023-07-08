package car.domain;

import car.domain.model.Car;
import car.domain.model.Cars;
import car.domain.model.Count;
import car.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

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
        int maxPosition = this.cars.getCars()
            .stream()
            .mapToInt(Car::getPosition)
            .max().getAsInt();
        return this.cars.getCars()
            .stream()
            .filter(car -> (car.getPosition() == maxPosition))
            .collect(Collectors.toList());
    }

}
