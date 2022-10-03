package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.queryCarNames();
        int numberOfTrials = InputView.queryNumberOfTrials();

        List<Car> cars = createCars(carNames);
        CarRace race = new CarRace(cars);
        for (int i = 0; i < numberOfTrials; i++) {
            race.round();
            ResultView.printCars(cars);
        }
        ResultView.printWinners(race.getWinners());
    }

    private static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }
}
