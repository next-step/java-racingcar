package race;

import race.domain.Car;
import race.domain.Cars;
import race.utils.RandomStrategy;
import race.view.InputView;
import race.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String STANDARD_SPLIT_REGEX = ",";
    private final OutputView outputView;
    private final InputView inputView;
    private int winnerPosition;

    public RacingGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        String[] names = inputView.askNameOfCar().split(STANDARD_SPLIT_REGEX);
        int carNumbers = names.length;
        int attempts = inputView.askNumberOfAttempts();

        outputView.printResultStatement();

        Cars cars = new Cars(carNumbers, names);
        List<Car> racingCars = new ArrayList<>();
        for (int attempt = 0; attempt < attempts; attempt++) {
            racingCars = cars.goForward(new RandomStrategy());
            outputView.printMileages(racingCars);
            outputView.printNewLine();
        }

        winnerPosition = getWinnerPosition(racingCars);
        String winnerNames = getWinnerNames(racingCars);
        System.out.print(winnerNames);
    }

    private String getWinnerNames(List<Car> racingCars) {
        return racingCars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getWinnerPosition(List<Car> racingCars) {
        return racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

}
