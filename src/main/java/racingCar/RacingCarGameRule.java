package racingCar;

import racingCar.ui.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingCarGameRule {
    private List<Car> raceCar;
    private ResultView resultView = new ResultView();

    RacingCarGameRule(List<Car> raceCar) {
        this.raceCar = raceCar;
    }

    public void printWinners() {
        List<Car> winnerCars = raceCar.stream()
                .filter(car -> car.getMoveCount() == maxMoveCar().getMoveCount())
                .collect(Collectors.toList());

        resultView.printWinners(winnerCars);
    }

    private Car maxMoveCar() {
        return raceCar.stream()
                .max(Comparator.comparingInt(Car::getMoveCount))
                .orElseThrow(NoSuchElementException::new);
    }
}
