package step5.domain.race;

import step5.domain.car.Car;
import step5.domain.car.Cars;
import step5.domain.car.Name;
import step5.view.result.ResultView;

import java.util.stream.Collectors;

public class RaceResult {

    private final RacingGame racingGame;
    private final Cars cars;

    private boolean isFirstRace;

    public RaceResult(RacingGame racingGame, Cars cars, boolean isFirstRace) {
        this.racingGame = racingGame;
        this.cars = cars;
        this.isFirstRace = isFirstRace;
    }

    public void printProgressOfRace() {
        if(isFirstRace)
            printTitle();

        ResultView resultView = new ResultView();
        resultView.printProgressOfRace(cars);

        if (racingGame.isFinished()) {
            resultView.printWinnerOfRacing(getWinnersName());
        }
    }

    public Cars getWinnerCarsOfRace() {
        if (racingGame.isFinished())
            return cars.getFarthestMovedCars();

        throw new IllegalStateException("race is not finished yet");
    }

    public String getWinnersName() {
        if (racingGame.isFinished()) {
            Cars farthestMovedCars = cars.getFarthestMovedCars();
            String winnersName = farthestMovedCars.stream()
                    .map(Car::getName)
                    .map(Name::getValue)
                    .collect(Collectors.joining(","));
            return winnersName;
        }

        throw new IllegalStateException("race is not finished yet");
    }

    private void printTitle() {
        System.out.println("실행 결과");
    }
}
