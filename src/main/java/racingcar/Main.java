package racingcar;

import racingcar.strategy.RandomMovableStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int numberOfCars = InputView.queryNumberOfCars();
        int numberOfTrials = InputView.queryNumberOfTrials();

        CarRace carRace = new CarRace(numberOfCars, new RandomMovableStrategy());
        for (int i = 0; i < numberOfTrials; i++) {
            carRace.race();
            ResultView.printCars(carRace.getCars());
        }
    }
}
