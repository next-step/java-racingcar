package step5.domain.race;

import step5.domain.car.Car;
import step5.domain.car.Cars;
import step5.domain.car.Name;
import step5.view.result.ResultView;

import java.util.stream.Collectors;

public class RacingGame {

    private static final int GAME_COUNT_LOWER_BOUND = 0;

    private final Cars cars;
    private final ResultView resultView;

    private int remainGameCount;

    public RacingGame(String[] carNames, int remainGameCount, ResultView resultView) {
        this.cars = new Cars(carNames);
        this.remainGameCount = remainGameCount;
        this.resultView = resultView;
    }

    public void race() {
        validateLimit();
        remainGameCount--;
        cars.tryMove();
        printRaceResult();
    }

    private void printRaceResult() {
        resultView.printProgressOfRace(cars, this);
    }

    public Cars getWinnerCarsOfRace() {
        if (isFinished())
            return cars.getFarthestMovedCars();

        throw new IllegalStateException("race is not finished yet");
    }

    public String getWinnersName() {
        if (isFinished()) {
            Cars farthestMovedCars = cars.getFarthestMovedCars();
            String winnersName = farthestMovedCars.stream()
                    .map(Car::getName)
                    .map(Name::getValue)
                    .collect(Collectors.joining(","));
            return winnersName;
        }

        throw new IllegalStateException("race is not finished yet");
    }

    public boolean isFinished() {
        return remainGameCount == GAME_COUNT_LOWER_BOUND;
    }

    private void validateLimit() {
        if (remainGameCount <= GAME_COUNT_LOWER_BOUND)
            throw new IllegalStateException("remainGameCount is zero");
    }
}
